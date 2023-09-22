package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import java.util.List;

public interface RetrieveNoticeUseCase {

    NoticeInfoResponseDto retrieveSingleNoticeInfo(Long nId);

    List<NoticeInfoResponseDto> retrieveMultiNoticeInfo(Long nId);
}
