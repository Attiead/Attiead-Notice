package in.attiead.notice.domain;

public record NoticeAttachment(
    Long id,
    String originalFileName,
    String savedFileName
) {

  public NoticeAttachment(String originalFileName, String savedFileName) {
    this(null, originalFileName, null);
  }
}
