package in.attiead.notice.common.util;

import in.attiead.notice.common.exception.InternalServerException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Getter
public class FileUtils {

  private final Path uploadDir;

  public FileUtils(@Value("${upload.path}") String uploadDir) {
    Path path = Paths.get(uploadDir);
    if (!path.isAbsolute()) {
      path = path.toAbsolutePath().normalize();
    }
    this.uploadDir = path;
    init();
  }

  private void init() {
    try {
      if (!Files.exists(uploadDir))
        Files.createDirectories(uploadDir);
    } catch (IOException e) {
      throw new InternalServerException(FileException.FAIL_TO_SAVE_DATA.getMessage());
    }
  }

  public void saveFileToPath(MultipartFile file, String saveFileName) {
    try {
      Path path = uploadDir.resolve(saveFileName);
      Files.createFile(path);
      file.transferTo(path);
    } catch (IOException e) {
      throw new InternalServerException(FileException.FAIL_TO_SAVE_DATA.getMessage());
    }
  }
}
