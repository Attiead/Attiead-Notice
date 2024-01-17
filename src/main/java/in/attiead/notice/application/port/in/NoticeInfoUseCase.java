package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import in.attiead.notice.adapter.in.dto.NoticeUpdateRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeInfoUseCase {

  NoticeInfoResponseDTO getNoticeInfo(Long nid);

  Page<NoticeInfoResponseDTO> getNotices(Pageable pageable);

  void updateNoticeInfo(NoticeUpdateRequestDTO noticeUpdateRequestDto);

}
