package in.attiead.notice.common.util;

import in.attiead.notice.common.exception.InternalServerException;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Getter
public class FileUtils {

  @Value("${upload.path}")
  private String uploadDir;

  @PostConstruct
  public void init() {
    File file = new File(uploadDir);
    if (!file.isAbsolute()) {
      uploadDir = System.getProperty("user.dir") + File.separator + uploadDir;
      file = new File(uploadDir);
    }

    if (!file.exists()) {
      file.mkdirs();
    }
  }

  public void saveFileToPath(MultipartFile file, String saveFileName) {
    try {
      String filePath = getUploadDir() + File.separator + saveFileName;
      file.transferTo(new File(filePath));
    } catch (IOException e) {
      throw new InternalServerException(FileException.FAIL_TO_SAVE_DATA.getMessage());
    }
  }
}
