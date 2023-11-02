package in.attiead.notice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Notice {

    private final NoticeId noticeId;
    private NoticeContent content;
    private NoticeState state;
    private NoticeCategory category;
    private NoticeTimeInfo timeInfo;

    public Notice(NoticeId noticeId) {
        this.noticeId = noticeId;
    }

    @Builder
    public Notice(
            NoticeId noticeId,
            NoticeContent noticeContent,
            NoticeState noticeState,
            NoticeCategory noticeCategory,
            NoticeTimeInfo noticeTimeInfo
    ) {
        this.noticeId = noticeId;
        this.content = noticeContent;
        this.state = noticeState;
        this.category = noticeCategory;
        this.timeInfo = noticeTimeInfo;
    }

    public static Notice onlyId(Long nid) {
        return new Notice(new NoticeId(nid));
    }

    public static Notice withoutId(NoticeContent noticeContent) {
        return new Notice(
                new NoticeId(null),
                noticeContent,
                NoticeState.ACTIVE,
                NoticeCategory.OPERATE,
                new NoticeTimeInfo()
        );
    }

    public void updateNoticeInfo(
            NoticeContent noticeContent,
            NoticeCategory noticeCategory,
            NoticeState noticeState
    ) {
        this.category = noticeCategory;
        this.content = noticeContent;
        this.state = noticeState;
    }

    public record NoticeId(Long id) {

    }
}
