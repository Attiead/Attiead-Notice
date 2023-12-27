package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeAttachment;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class NoticeCreateService implements NoticeCreateUseCase {

  private final CreateNoticePort createNoticePort;
  private final NoticeAttachmentService noticeAttachmentService;

  @Override
  @Transactional
  public void createNotice(
      NoticeCreateRequestDTO noticeCreateRequestDTO,
      List<MultipartFile> files
  ) {
    List<NoticeAttachment> noticeAttachments = null;
    if (files != null) {
      noticeAttachments = noticeAttachmentService.createAttachment(files);
    }

    Notice newNotice = Notice.withoutId(
        noticeCreateRequestDTO.mapToNoticeContent(),
        noticeAttachments
    );
    createNoticePort.saveNotice(newNotice);
  }
}
