package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.in.dto.ResponseDto;
import in.attiead.notice.application.port.in.RetrieveNoticeUseCase;
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
class RetrieveNoticeController {

  private final RetrieveNoticeUseCase retrieveNoticeUseCase;

  @GetMapping("/{nId}")
  public ResponseDto<NoticeInfoResponseDto> retrieveSingleNoticeInfo(@PathVariable Long nId) {
    NoticeInfoResponseDto noticeInfoResponseDto = retrieveNoticeUseCase.retrieveSingleNoticeInfo(
        nId);
    return ResponseDto.success(noticeInfoResponseDto);
  }

  public ResponseDto<Page<NoticeInfoResponseDto>> retrieverMultiNoticeInfo(Pageable pageable) {
    Page<NoticeInfoResponseDto> noticePageInfoResponseDto = retrieveNoticeUseCase.retrieveMultiNoticeInfo(
        pageable);
    return ResponseDto.success(noticePageInfoResponseDto);
  }
}