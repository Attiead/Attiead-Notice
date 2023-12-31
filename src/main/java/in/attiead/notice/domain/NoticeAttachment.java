package in.attiead.notice.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record NoticeAttachment(
    Long id,
    String originalFileName,
    String saveFileName
) {

  public NoticeAttachment(String originalFileName) {
    this(null, originalFileName, null);
  }

  public static List<NoticeAttachment> createNoticeAttachments(List<MultipartFile> files) {
    List<NoticeAttachment> attachments = new ArrayList<>();
    for (MultipartFile file : files) {
      String originalFilename = file.getOriginalFilename();
      attachments.add(new NoticeAttachment(originalFilename));
    }
    return attachments;
  }
}
