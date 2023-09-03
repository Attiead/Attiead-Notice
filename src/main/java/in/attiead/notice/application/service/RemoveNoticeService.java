package in.attiead.notice.application.service;

import in.attiead.notice.application.port.in.RemoveNoticeUseCase;
import in.attiead.notice.application.port.out.RemoveNoticePort;
import in.attiead.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveNoticeService implements RemoveNoticeUseCase {

    private final RemoveNoticePort removeNoticePort;

    @Override
    public void removeNotice(Long nid) {
        Notice deletedNotice = Notice.withLongId(nid);
        removeNoticePort.deleteNotice(deletedNotice);
    }
}
