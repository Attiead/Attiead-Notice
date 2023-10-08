package in.attiead.notice.application.port.out;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetNoticeInfoPort {

    Notice getSingleNoticeInfo(Notice notice);

    Page<NoticeInfoResponseDto> getNotices(Pageable pageable);

}