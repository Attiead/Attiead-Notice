package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.ResponseDto;
import in.attiead.notice.application.port.in.NoticeRemoveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
class NoticeRemoveController {

  private final NoticeRemoveUseCase noticeRemoveUseCase;

  @DeleteMapping("/{nid}")
  public ResponseDto<Void> removeNotice(@PathVariable Long nid) {
    noticeRemoveUseCase.removeNotice(nid);
    return ResponseDto.success(null);
  }
}
