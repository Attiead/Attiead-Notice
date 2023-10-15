package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.common.exception.NotFoundException;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.Notice.NoticeId;
import in.attiead.notice.domain.NoticeContent;
import in.attiead.notice.domain.NoticeTimeInfo;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoticeMapper {

  NoticeJpaEntity mapToJpaEntity(Notice notice) {
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

  Notice mapToDomainEntity(Optional<NoticeJpaEntity> noticeJpaEntity) {
    if (noticeJpaEntity.isEmpty()) {
      throw new NotFoundException("noticeJpaEntity not found", noticeJpaEntity);
    }
    return Notice.builder()
        .noticeId(
            new NoticeId(noticeJpaEntity.get().getId())
        )
        .noticeContent(
            new NoticeContent(
                noticeJpaEntity.get().getContent().getTitle(),
                noticeJpaEntity.get().getContent().getContent(),
                noticeJpaEntity.get().getContent().getAuthor()
            )
        )
        .noticeCategory(noticeJpaEntity.get().getCategory())
        .noticeState(noticeJpaEntity.get().getState())
        .noticeTimeInfo(
            new NoticeTimeInfo(
                noticeJpaEntity.get().getCreatedAt(),
                noticeJpaEntity.get().getUpdatedAt()
            )
        )
        .build();
  }

  public NoticeInfoResponseDto mapToNoticeInfoResponseDto(Notice notice) {
    return new NoticeInfoResponseDto(
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

  public NoticeInfoResponseDto mapToNoticeInfoResponseDto(NoticeJpaEntity noticeJpaEntity) {
    return new NoticeInfoResponseDto(
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
