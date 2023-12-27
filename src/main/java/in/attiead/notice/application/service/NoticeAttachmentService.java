package in.attiead.notice.application.service;

import in.attiead.notice.common.util.FileUtils;
import in.attiead.notice.domain.NoticeAttachment;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class NoticeAttachmentService {

  private final FileUtils fileUtils;

  public List<NoticeAttachment> createAttachment(List<MultipartFile> files) {
    List<NoticeAttachment> noticeAttachments = new ArrayList<>();
    for (MultipartFile file : files) {
      String originalFilename = file.getOriginalFilename();
      String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
      String savedFileName = UUID.randomUUID() + extension;
      noticeAttachments.add(
          new NoticeAttachment(
              originalFilename,
              savedFileName
          )
      );
      fileUtils.saveFileToPath(file, savedFileName);
    }
    return noticeAttachments;
  }
}
