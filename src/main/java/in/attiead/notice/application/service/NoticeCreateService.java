package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.adapter.out.persistence.NoticeJpaEntity;
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
    Notice newNotice = Notice.withoutId(noticeCreateRequestDTO.mapToNoticeContent());
    NoticeJpaEntity noticeJpaEntity = createNoticePort.saveNotice(newNotice);
    if (files != null && !files.isEmpty()) {
      createNoticeAttachment(files, noticeJpaEntity);
    }
  }

  private void createNoticeAttachment(
      List<MultipartFile> files,
      NoticeJpaEntity noticeJpaEntity
  ) {
    List<NoticeAttachment> noticeAttachments = new ArrayList<>();
    files.forEach(file -> {
      Pair<String, String> noticeAttachmentInfo = fileUtils.saveFileToPath(file);
      NoticeAttachment noticeAttachment = NoticeAttachment.createNoticeAttachment(
          noticeAttachmentInfo);
      noticeAttachments.add(noticeAttachment);
    });
    crudNoticeAttachmentPort.saveNoticeAttachment(noticeAttachments, noticeJpaEntity);
  }
}
