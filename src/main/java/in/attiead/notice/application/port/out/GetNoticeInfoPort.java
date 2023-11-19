package in.attiead.notice.application.port.out;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import in.attiead.notice.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetNoticeInfoPort {

    Notice getNoticeById(Notice.NoticeId noticeId);

    Page<NoticeInfoResponseDTO> getNotices(Pageable pageable);

}
