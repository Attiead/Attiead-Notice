package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.adapter.in.dto.ResponseDTO;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import jakarta.validation.Valid;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
class NoticeCreateController {

  private final NoticeCreateUseCase noticeCreateUseCase;

  @PostMapping
  public ResponseDTO<Void> createNotice(
      @Valid @RequestBody NoticeCreateRequestDTO noticeCreateRequestDto,
      @RequestParam(value = "file", required = false) MultipartFile files) {
    noticeCreateUseCase.createNotice(noticeCreateRequestDto, files);
    return ResponseDTO.success(null);
  }
}

