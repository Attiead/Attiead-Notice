package in.attiead.notice.common.util;

import in.attiead.notice.common.exception.InternalServerException;
import in.attiead.notice.domain.NoticeAttachment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileManager {

  private final String savePath = System.getProperty("user.dir") + "/files";

  @EventListener(ApplicationReadyEvent.class)
  public void init() {
    makeDir();
  }

  public List<NoticeAttachment> mapToNoticeAttachment(List<MultipartFile> files) {
    if (files == null)
      return null;

    List<NoticeAttachment> noticeAttachments = new ArrayList<>();
    for (MultipartFile file : files) {
      String originalFileName = file.getOriginalFilename();
      String filePath = savePath + "/" + originalFileName;
      noticeAttachments.add(
          new NoticeAttachment(
              originalFileName,
              filePath
          )
      );
      saveFileToPath(file, filePath);
    }
    return noticeAttachments;
  }

  private void makeDir() {
    File file = new File(savePath);
    if (!file.exists()) {
      file.mkdir();
    }
  }

  private void saveFileToPath(MultipartFile file, String filePath) {
    try {
      file.transferTo(new File(filePath));
    } catch (IOException e) {
      throw new InternalServerException(FileSaveException.FAIL_TO_SAVA_DATA.getMessage());
    }
  }
}
