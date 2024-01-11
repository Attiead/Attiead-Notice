package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.application.port.out.CrudNoticeAttachmentPort;
import in.attiead.notice.domain.NoticeAttachment;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class NoticeAttachmentPersistenceAdapter implements CrudNoticeAttachmentPort {

  private final NoticeAttachmentRepository noticeAttachmentRepository;
  private final NoticeMapper noticeMapper;

  @Override
  public void saveNoticeAttachment(List<NoticeAttachment> noticeAttachments) {
    noticeAttachments.forEach(noticeAttachment -> {
      AttachmentJpaEntity attachmentJpaEntity = noticeMapper.mapToAttachmentJpaEntity(
          noticeAttachment);
      noticeAttachmentRepository.save(attachmentJpaEntity);
    });
  }

  @Override
  public void deleteNoticeAttachment(Long noticeAttachmentId) {
    noticeAttachmentRepository.deleteById(noticeAttachmentId);
  }
}
