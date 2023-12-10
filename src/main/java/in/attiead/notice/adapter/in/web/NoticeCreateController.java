package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.adapter.in.dto.ResponseDTO;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
class NoticeCreateController {

  private final NoticeCreateUseCase noticeCreateUseCase;

  @PostMapping
  public ResponseDTO<Void> createNotice(
      @Valid @RequestPart NoticeCreateRequestDTO noticeCreateRequestDto,
      @RequestPart(value = "file", required = false) List<MultipartFile> files) {
    noticeCreateUseCase.createNotice(noticeCreateRequestDto, files);
    return ResponseDTO.success(null);
  }
}
