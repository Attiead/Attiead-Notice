package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.in.dto.NoticeUpdateRequestDto;
import in.attiead.notice.adapter.in.dto.ResponseDto;
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
  public ResponseDto<NoticeInfoResponseDto> getNoticeInfo(@PathVariable Long nid) {
    NoticeInfoResponseDto noticeInfoResponseDto = noticeInfoUseCase.getNoticeInfo(nid);
    return ResponseDto.success(noticeInfoResponseDto);
  }

  @GetMapping
  public ResponseDto<Page<NoticeInfoResponseDto>> getNotices(@PageableDefault(size = 10) Pageable pageable) {
      Page<NoticeInfoResponseDto> noticePageInfoResponsDto = noticeInfoUseCase.getNotices(pageable);
      return ResponseDto.success(noticePageInfoResponsDto);
  }

  @PatchMapping
  public ResponseDto<NoticeInfoResponseDto> updateNoticeInfo(@Valid @RequestBody NoticeUpdateRequestDto noticeUpdateRequestDto) {
    noticeInfoUseCase.updateNoticeInfo(noticeUpdateRequestDto);
    NoticeInfoResponseDto updateInfo = noticeInfoUseCase.getNoticeInfo(noticeUpdateRequestDto.nid());
    return ResponseDto.success(updateInfo);
  }
}
