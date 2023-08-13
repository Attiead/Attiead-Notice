package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeCategory;
import in.attiead.notice.domain.NoticeContent;
import in.attiead.notice.domain.NoticeState;
import org.springframework.stereotype.Component;

@Component
class NoticeMapper {

    NoticeJpaEntity mapToJpaEntity(
            Notice notice,
            NoticeContent noticeContent) {
        return NoticeJpaEntity.builder()
                .id(notice.getNoticeid().getId())
                .title(noticeContent.getTitle())
                .content(noticeContent.getContent())
                .author(noticeContent.getAuthor())
                .category(NoticeCategory.OPERATE) // 추후 수정 필요
                .state(NoticeState.STANDBY)
                .build();
    }
}
