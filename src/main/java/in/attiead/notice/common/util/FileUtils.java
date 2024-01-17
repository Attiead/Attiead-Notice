package in.attiead.notice.common.util;

import in.attiead.notice.common.exception.InternalServerException;
import in.attiead.notice.domain.NoticeAttachment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtils {

  private final Path uploadDirectory;

  public FileUtils(@Value("${upload.path}") String uploadDirectory) {
    Path path = Paths.get(uploadDirectory);
    if (!path.isAbsolute()) {
      path = path.toAbsolutePath().normalize();
    }
    this.uploadDirectory = path;
    init();
  }

  private void init() {
    try {
      if (!Files.exists(uploadDirectory)) {
        Files.createDirectories(uploadDirectory);
      }
    } catch (IOException e) {
      throw new InternalServerException(FileExceptionMessages.FAIL_TO_SAVE_DATA.getMessage());
    }
  }

  public Pair<String, String> saveFileToPath(MultipartFile file) {
    String serverFileName = UUID.randomUUID().toString();
    Path path = uploadDirectory.resolve(serverFileName);
    try {
      file.transferTo(path);
    } catch (IOException e) {
      throw new InternalServerException(FileExceptionMessages.FAIL_TO_SAVE_DATA.getMessage());
    }
    return Pair.of(serverFileName, path.toString());
  }
}
