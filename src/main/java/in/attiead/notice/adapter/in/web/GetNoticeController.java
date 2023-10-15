package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.in.dto.ResponseDto;
import in.attiead.notice.application.port.in.GetNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
class GetNoticeController {

  private final GetNoticeUseCase getNoticeUseCase;

  @GetMapping("/{nId}")
  public ResponseDto<NoticeInfoResponseDto> getSingleNoticeInfo(@PathVariable Long nId) {
    NoticeInfoResponseDto noticeInfoResponseDto = getNoticeUseCase.getSingleNoticeInfo(nId);

    return ResponseDto.success(noticeInfoResponseDto);
  }

  @GetMapping
  public ResponseDto<Page<NoticeInfoResponseDto>> getNotices(@RequestParam(required = false) Integer page) {
      Pageable pageable = PageRequest.of(page - 1, 10);
      Page<NoticeInfoResponseDto> noticePageInfoResponsDto = getNoticeUseCase.getNotices(pageable);

      return ResponseDto.success(noticePageInfoResponsDto);
    }
}
