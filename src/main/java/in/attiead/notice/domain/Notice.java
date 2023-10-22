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

  public static Notice onlyId(Long nId) {
    return new Notice(new NoticeId(nId));
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

  public record NoticeId(Long id) {

  }
}
