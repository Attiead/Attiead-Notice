package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetNoticeUseCase {

  NoticeInfoResponseDto getSingleNoticeInfo(Long nId);

  Page<NoticeInfoResponseDto> getNotices(Pageable pageable);

}
