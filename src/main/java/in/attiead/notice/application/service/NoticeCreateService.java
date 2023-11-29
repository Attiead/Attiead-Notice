package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeAttachment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
  public void createNotice(
      NoticeCreateRequestDTO noticeCreateRequestDTO,
      List<MultipartFile> files
  ) {
    if (files != null && !files.isEmpty()) {
      List<String> originalFileNames = new ArrayList<>();
      String savePath = System.getProperty("user.dir") + "/files";
      List<String> filePaths = new ArrayList<>();
      try {
        if (!new File(savePath).exists()) {
          new File(savePath).mkdir();
        }

        for (MultipartFile file : files) {
          String originalFileName = file.getOriginalFilename();
          originalFileNames.add(originalFileName);
          String filePath = savePath + "/" + originalFileName;
          filePaths.add(filePath);
          file.transferTo(new File(filePath));
        }

        Notice newNotice = Notice.withoutId(
            noticeCreateRequestDTO.mapToNoticeContent(),
            new NoticeAttachment(
                originalFileNames,
                filePaths
            )
        );
        createNoticePort.saveNotice(newNotice);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
