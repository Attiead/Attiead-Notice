package in.attiead.notice.domain;

public record NoticeAttachment(
    Long id,
    String originalFileName,
    String filePath
) {

  public NoticeAttachment(String originalFileName, String filePath) {
    this(null, originalFileName, filePath);
  }
}
