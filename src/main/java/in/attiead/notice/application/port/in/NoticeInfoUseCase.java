package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeInfoUseCase {

  NoticeInfoResponseDto getNoticeInfo(Long nId);

  Page<NoticeInfoResponseDto> getNotices(Pageable pageable);

}
