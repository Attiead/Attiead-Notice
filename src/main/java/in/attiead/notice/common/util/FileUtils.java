package in.attiead.notice.common.util;

import in.attiead.notice.common.exception.InternalServerException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
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
      throw new InternalServerException(FileExceptionMessages.FAIL_TO_SAVE_DATA.getMessage());
    }
  }

  public void saveFileToPath(List<MultipartFile> files) {
    try {
      for (MultipartFile file : files) {
        String originalFilename = file.getOriginalFilename();
        String saveFileName = generateSaveFileName(originalFilename);
        Path path = uploadDir.resolve(saveFileName);
        file.transferTo(path);
      }
    } catch (IOException e) {
      throw new InternalServerException(FileExceptionMessages.FAIL_TO_SAVE_DATA.getMessage());
    }
  }

  private String generateSaveFileName(String originalFilename) {
    String extension = "";
    if (originalFilename != null) {
      int lastIndex = originalFilename.lastIndexOf(".");
      if (lastIndex != -1) {
        extension = originalFilename.substring(lastIndex);
      }
    }
    return UUID.randomUUID() + extension;
  }
}
