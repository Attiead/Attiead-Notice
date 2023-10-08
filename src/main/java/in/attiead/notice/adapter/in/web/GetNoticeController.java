package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.in.dto.ResponseDto;
import in.attiead.notice.application.port.in.GetNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
class GetNoticeController {

  private final GetNoticeUseCase getNoticeUseCase;

  @GetMapping("/{nId}")
  public ResponseDto<NoticeInfoResponseDto> getSingleNoticeInfo(@PathVariable Long nId) {
    NoticeInfoResponseDto noticeInfoResponseDto = getNoticeUseCase.getSingleNoticeInfo(
        nId);

    return ResponseDto.success(noticeInfoResponseDto);
  }

  @GetMapping
  public ResponseDto<Page<NoticeInfoResponseDto>> getNotices(Pageable pageable) {
    Page<NoticeInfoResponseDto> noticePageInfoResponseDto = getNoticeUseCase.getNotices(
        pageable);

    return ResponseDto.success(noticePageInfoResponseDto);
  }
}
