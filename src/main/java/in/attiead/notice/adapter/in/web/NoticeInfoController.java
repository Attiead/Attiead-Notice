package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import in.attiead.notice.adapter.in.dto.NoticeUpdateRequestDTO;
import in.attiead.notice.adapter.in.dto.ResponseDTO;
import in.attiead.notice.application.port.in.NoticeInfoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
class NoticeInfoController {

  private final NoticeInfoUseCase noticeInfoUseCase;

  @GetMapping("/{nid}")
  public ResponseDTO<NoticeInfoResponseDTO> getNoticeInfo(@PathVariable Long nid) {
    NoticeInfoResponseDTO noticeInfoResponseDto = noticeInfoUseCase.getNoticeInfo(nid);
    return ResponseDTO.success(noticeInfoResponseDto);
  }

  @GetMapping
  public ResponseDTO<Page<NoticeInfoResponseDTO>> getNotices(@PageableDefault(size = 10) Pageable pageable) {
    Page<NoticeInfoResponseDTO> noticePageInfoResponseDto = noticeInfoUseCase.getNotices(pageable);
    return ResponseDTO.success(noticePageInfoResponseDto);
  }

  @PatchMapping
  public ResponseDTO<NoticeInfoResponseDTO> updateNoticeInfo(@Valid @RequestBody NoticeUpdateRequestDTO noticeUpdateRequestDto) {
    noticeInfoUseCase.updateNoticeInfo(noticeUpdateRequestDto);
    NoticeInfoResponseDTO updateInfo = noticeInfoUseCase.getNoticeInfo(noticeUpdateRequestDto.nid());
    return ResponseDTO.success(updateInfo);
  }
}
