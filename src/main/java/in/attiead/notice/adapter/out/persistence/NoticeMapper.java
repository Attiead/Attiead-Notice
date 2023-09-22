package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.Notice.NoticeId;
import in.attiead.notice.domain.NoticeContent;
import in.attiead.notice.domain.NoticeTimeInfo;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class NoticeMapper {

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
}
