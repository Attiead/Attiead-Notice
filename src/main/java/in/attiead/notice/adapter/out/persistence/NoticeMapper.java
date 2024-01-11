package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.Notice.NoticeId;
import in.attiead.notice.domain.NoticeAttachment;
import in.attiead.notice.domain.NoticeContent;
import in.attiead.notice.domain.NoticeTimeInfo;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoticeMapper {

  NoticeJpaEntity mapToNoticeJpaEntity(Notice notice) {
  /*
    List<AttachmentJpaEntity> attachments = new ArrayList<>();
    if (notice.getNoticeAttachments() != null) {
      attachments = notice.getNoticeAttachments()
          .stream()
          .map(this::mapToAttachmentJpaEntity)
          .toList();
    }
  */
    return NoticeJpaEntity.builder()
        .id(notice.getNoticeId().id())
        .content(
            new Content(
                notice.getContent().title(),
                notice.getContent().content(),
                notice.getContent().author()
            )
        )
        .category(notice.getCategory())
        .state(notice.getState())
        .build();
  }



  Notice mapToNoticeDomainEntity(NoticeJpaEntity noticeJpaEntity) {
    return Notice.builder()
        .noticeId(
            new NoticeId(noticeJpaEntity.getId())
        )
        .noticeContent(
            new NoticeContent(
                noticeJpaEntity.getContent().getTitle(),
                noticeJpaEntity.getContent().getContent(),
                noticeJpaEntity.getContent().getAuthor()
            )
        )
        .noticeCategory(noticeJpaEntity.getCategory())
        .noticeState(noticeJpaEntity.getState())
        .noticeTimeInfo(
            new NoticeTimeInfo(
                noticeJpaEntity.getCreatedAt(),
                noticeJpaEntity.getUpdatedAt()
            )
        )
        .noticeAttachments(mapToNoticeAttachment(noticeJpaEntity.getAttachments()))
        .build();
  }

  List<NoticeAttachment> mapToNoticeAttachment(List<AttachmentJpaEntity> attachmentJpaEntities) {
    List<NoticeAttachment> noticeAttachments = new ArrayList<>();
    if (attachmentJpaEntities != null) {
      attachmentJpaEntities.forEach(attachmentJpaEntity -> {
        NoticeAttachment noticeAttachment = new NoticeAttachment(
            attachmentJpaEntity.getId(),
            attachmentJpaEntity.getServerFileName(),
            attachmentJpaEntity.getFilePath()
        );
        noticeAttachments.add(noticeAttachment);
      });
    }
    return noticeAttachments;
  }

  public NoticeInfoResponseDTO mapToNoticeInfoResponseDto(Notice notice) {
    return new NoticeInfoResponseDTO(
        notice.getNoticeId().id(),
        notice.getContent().title(),
        notice.getContent().content(),
        notice.getContent().author(),
        notice.getCategory().name(),
        notice.getState().name(),
        notice.getTimeInfo().createdAt(),
        notice.getTimeInfo().updatedAt(),
        notice.getNoticeAttachments()
    );
  }

  public NoticeInfoResponseDTO mapToNoticeInfoResponseDto(NoticeJpaEntity noticeJpaEntity) {
    return new NoticeInfoResponseDTO(
        noticeJpaEntity.getId(),
        noticeJpaEntity.getContent().getTitle(),
        noticeJpaEntity.getContent().getContent(),
        noticeJpaEntity.getContent().getAuthor(),
        noticeJpaEntity.getCategory().name(),
        noticeJpaEntity.getState().name(),
        noticeJpaEntity.getCreatedAt(),
        noticeJpaEntity.getUpdatedAt(),
        mapToNoticeAttachment(noticeJpaEntity.getAttachments())
    );
  }

  AttachmentJpaEntity mapToAttachmentJpaEntity(NoticeAttachment noticeAttachment) {
    return AttachmentJpaEntity.builder()
        .id(noticeAttachment.id())
        .serverFileName(noticeAttachment.serverFileName())
        .filePath(noticeAttachment.filePath())
        .build();
  }
}
