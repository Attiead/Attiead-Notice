package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.domain.Notice;
import org.springframework.stereotype.Component;

@Component
class NoticeMapper {

    NoticeJpaEntity mapToJpaEntity(
            Notice notice) {
        return NoticeJpaEntity.builder()
                .id(notice.getNoticeid().getId())
                .content(
                        new Content(
                                notice.getNoticeContent().getTitle(),
                                notice.getNoticeContent().getContent(),
                                notice.getNoticeContent().getAuthor()
                        )
                )
                .category(notice.getCategory())
                .state(notice.getState())
                .build();
    }
}
