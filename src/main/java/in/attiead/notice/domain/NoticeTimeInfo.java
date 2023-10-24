package in.attiead.notice.domain;

import java.time.LocalDateTime;

public record NoticeTimeInfo(
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
  public NoticeTimeInfo() {
    this(null, null);
  }
}
