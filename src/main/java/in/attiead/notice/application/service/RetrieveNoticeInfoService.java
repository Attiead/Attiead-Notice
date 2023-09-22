package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.application.port.in.RetrieveNoticeUseCase;
import in.attiead.notice.application.port.out.RetrieveNoticeInfoPort;
import in.attiead.notice.domain.Notice;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveNoticeInfoService implements RetrieveNoticeUseCase {

    private final RetrieveNoticeInfoPort retrieveNoticeInfoPort;

    @Override
    public NoticeInfoResponseDto retrieveSingleNoticeInfo(Long nId) {
        Notice singleNotice = Notice.withLongId(nId);
        retrieveNoticeInfoPort.retrieveSingleNoticeInfo(singleNotice);
        return null;
    }

    @Override
    public List<NoticeInfoResponseDto> retrieveMultiNoticeInfo(Long nId) {
        return null;
    }
}
