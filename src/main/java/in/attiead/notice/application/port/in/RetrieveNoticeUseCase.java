package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveNoticeUseCase {

    NoticeInfoResponseDto retrieveSingleNoticeInfo(Long nId);

    Page<NoticeInfoResponseDto> retrieveMultiNoticeInfo(Pageable pageable);
}
