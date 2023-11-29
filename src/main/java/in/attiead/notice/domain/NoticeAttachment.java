package in.attiead.notice.domain;

import java.util.List;

public record NoticeAttachment(
  Long id,
  List<String> originalFileName,
  List<String> filePath
) {
  public NoticeAttachment(List<String> originalFileNames, List<String> filePaths) {
    this(null, originalFileNames, filePaths);
  }
}
