package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeAttachment;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class NoticeCreateService implements NoticeCreateUseCase {

  private final CreateNoticePort createNoticePort;

  @Override
  @Transactional
  public void createNotice(NoticeCreateRequestDTO noticeCreateRequestDTO, MultipartFile files) {
    if (!files.isEmpty()) {
      try {
        String origFilename = files.getOriginalFilename();
        byte[] fileContentBytes = files.getBytes();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String storedFilename = Arrays.toString(md.digest(fileContentBytes));
        String savePath = System.getProperty("user.dir") + "\\files";
        if (!new File(savePath).exists()) {
          new File(savePath).mkdir();
        }
        String filePath = savePath + "\\" + storedFilename;
        files.transferTo(new File(filePath));
        Notice newNotice = Notice.withoutId(
            noticeCreateRequestDTO.mapToNoticeContent(),
            new NoticeAttachment(
                origFilename,
                storedFilename,
                filePath
            ));
        createNoticePort.saveNotice(newNotice);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
