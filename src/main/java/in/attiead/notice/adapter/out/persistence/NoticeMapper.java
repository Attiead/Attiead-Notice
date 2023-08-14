package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.domain.Notice;
import org.springframework.stereotype.Component;

@Component
class NoticeMapper {

    NoticeJpaEntity mapToJpaEntity(Notice notice) {
        return NoticeJpaEntity.builder()
                .id(notice.getNoticeid().id())
                .content(
                        new Content(
                                notice.getNoticeContent().title(),
                                notice.getNoticeContent().content(),
                                notice.getNoticeContent().author()
                        )
                )
                .category(notice.getCategory())
                .state(notice.getState())
                .build();
    }
}
