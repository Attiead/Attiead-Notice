package in.attiead.notice.application.service;

import in.attiead.notice.application.port.in.RemoveNoticeUseCase;
import in.attiead.notice.application.port.out.RemoveNoticePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveNoticeService implements RemoveNoticeUseCase {

    private final RemoveNoticePort removeNoticePort;

    @Override
    public void removeNotice(Long nid) {
        removeNoticePort.deleteNotice(nid);
    }
}
