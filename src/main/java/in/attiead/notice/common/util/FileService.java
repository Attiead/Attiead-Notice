package in.attiead.notice.common.util;

import in.attiead.notice.common.exception.InternalServerException;
import java.io.File;
import java.io.IOException;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Getter
public class FileService {

  private final String savePath = System.getProperty("user.dir") + "/files";

  public FileService() {
    makeDir();
  }

  public void saveFileToPath(MultipartFile file, String filePath) {
    try {
      file.transferTo(new File(filePath));
    } catch (IOException e) {
      throw new InternalServerException(FileSaveException.FAIL_TO_SAVE_DATA.getMessage());
    }
  }

  private void makeDir() {
    File file = new File(savePath);
    if (!file.exists()) {
      file.mkdir();
    }
  }
}
