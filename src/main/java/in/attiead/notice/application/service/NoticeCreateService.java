package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.application.port.out.CrudNoticeAttachmentPort;
import in.attiead.notice.common.util.FileUtils;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeAttachment;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class NoticeCreateService implements NoticeCreateUseCase {

  private final CreateNoticePort createNoticePort;
  private final CrudNoticeAttachmentPort crudNoticeAttachmentPort;
  private final FileUtils fileUtils;

  @Override
  @Transactional
  public void createNotice(
      NoticeCreateRequestDTO noticeCreateRequestDTO,
      List<MultipartFile> files
  ) {
    List<NoticeAttachment> noticeAttachments = new ArrayList<>();
    if (files != null && !files.isEmpty()) {
      files.forEach(file -> {
        Pair<String, String> noticeAttachmentInfo = fileUtils.saveFileToPath(file);
        NoticeAttachment noticeAttachment = NoticeAttachment.createNoticeAttachment(noticeAttachmentInfo);
        noticeAttachments.add(noticeAttachment);
      });
    }
    Notice newNotice = Notice.withoutId(
        noticeCreateRequestDTO.mapToNoticeContent()
    );
    createNoticePort.saveNotice(newNotice);
    crudNoticeAttachmentPort.saveNoticeAttachment(noticeAttachments);
  }

}
