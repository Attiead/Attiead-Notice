package in.attiead.notice.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record NoticeAttachment(
    Long id,
    String clientFileName,
    String serverFileName
) {

  public NoticeAttachment(String originalFileName) {
    this(null, originalFileName, null);
  }

  public static List<NoticeAttachment> createNoticeAttachments(List<MultipartFile> files) {
    List<NoticeAttachment> attachments = new ArrayList<>();
    for (MultipartFile file : files) {
      String clientFileName = file.getOriginalFilename();
      attachments.add(new NoticeAttachment(clientFileName));
    }
    return attachments;
  }
}
