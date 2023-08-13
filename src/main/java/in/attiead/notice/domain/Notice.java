package in.attiead.notice.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notice {

    private NoticeId noticeid;
    private NoticeContent noticeContent;
    private NoticeState state;
    private NoticeCategory category;

    public static Notice withId(
            NoticeId noticeId,
            NoticeContent noticeContent,
            NoticeState noticeState,
            NoticeCategory noticeCategory) {
        return new Notice(noticeId, noticeContent, noticeState, noticeCategory);
    }

    @EqualsAndHashCode(callSuper = true)
    @Value
        public record NoticeId(Long id) {
    }
}