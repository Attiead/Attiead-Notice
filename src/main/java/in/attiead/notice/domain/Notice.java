package in.attiead.notice.domain;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Notice {

  private final NoticeId noticeId;
  private NoticeContent content;
  private NoticeState state;
  private NoticeCategory category;
  private NoticeTimeInfo timeInfo;
  private List<NoticeAttachment> noticeAttachments;

  public Notice(NoticeId noticeId) {
    this.noticeId = noticeId;
  }

  @Builder
  public Notice(
      NoticeId noticeId,
      NoticeContent noticeContent,
      NoticeState noticeState,
      NoticeCategory noticeCategory,
      NoticeTimeInfo noticeTimeInfo,
      List<NoticeAttachment> noticeAttachments
  ) {
    this.noticeId = noticeId;
    this.content = noticeContent;
    this.state = noticeState;
    this.category = noticeCategory;
    this.timeInfo = noticeTimeInfo;
    this.noticeAttachments = noticeAttachments;
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
        new NoticeTimeInfo(),
        null
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
