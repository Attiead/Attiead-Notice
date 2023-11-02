package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.in.dto.NoticeUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeInfoUseCase {

  NoticeInfoResponseDto getNoticeInfo(Long nid);

  Page<NoticeInfoResponseDto> getNotices(Pageable pageable);

  void updateNoticeInfo(NoticeUpdateRequestDto noticeUpdateRequestDto);

}
