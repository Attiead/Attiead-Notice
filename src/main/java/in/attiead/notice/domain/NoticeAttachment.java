package in.attiead.notice.domain;

import org.springframework.data.util.Pair;

public record NoticeAttachment(
    Long id,
    String serverFileName,
    String filePath
) {

  public NoticeAttachment(String serverFileName, String filePath) {
    this(null, serverFileName, filePath);
  }

  public static NoticeAttachment createNoticeAttachment(Pair<String, String> noticeAttachmentInfo) {
    String serverFileName = noticeAttachmentInfo.getFirst();
    String filePath = noticeAttachmentInfo.getSecond();
    return new NoticeAttachment(serverFileName,filePath);
  }
}
