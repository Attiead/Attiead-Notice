package in.attiead.notice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notice {

    private final NoticeId noticeId;
    private final NoticeContent noticeContent;
    private final NoticeState state;
    private final NoticeCategory category;

    public static Notice withoutNoticeId(NoticeContent noticeContent) {
        return new Notice(
                null,
                noticeContent,
                NoticeState.ACTIVE,
                NoticeCategory.OPERATE
        );
    }

    public static Notice withNoticeId(
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

