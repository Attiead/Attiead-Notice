package in.attiead.notice.domain;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notice {

    private NoticeId noticeId;
    private NoticeContent noticeContent;
    private NoticeState state;
    private NoticeCategory category;

    public static Notice withId(
            NoticeId noticeId,
            NoticeContent noticeContent,
            NoticeState noticeState,
            NoticeCategory noticeCategory
    ) {
        return new Notice(
                noticeId,
                noticeContent,
                noticeState,
                noticeCategory
        );
    }

    public record NoticeId(Long id) {

    }
}

