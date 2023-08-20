package in.attiead.notice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
            NoticeContent noticeContent
    ) {
        return new Notice(
                noticeId,
                noticeContent,
                NoticeState.ACTIVE,
                NoticeCategory.OPERATE
        );
    }

    public record NoticeId(Long id) {

    }
}

