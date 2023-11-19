package in.attiead.notice.domain;

public record NoticeAttachment(
  Long id,
  String origFilename,
  String storedFilename,
  String filePath
) {
  public NoticeAttachment(String origFilename, String storedFilename, String filePath) {
    this(null, origFilename, storedFilename, filePath);
  }
}
