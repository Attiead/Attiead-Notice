package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.Notice.NoticeId;
import in.attiead.notice.domain.NoticeAttachment;
import in.attiead.notice.domain.NoticeContent;
import in.attiead.notice.domain.NoticeTimeInfo;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoticeMapper {

  NoticeJpaEntity mapToNoticeJpaEntity(Notice notice) {
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

  Notice mapToDomainEntity(NoticeJpaEntity noticeJpaEntity) {
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
        .build();
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
        notice.getTimeInfo().updatedAt()
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
        noticeJpaEntity.getUpdatedAt()
    );
  }
}
