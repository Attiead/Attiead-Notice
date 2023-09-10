package in.attiead.notice.application.service;

import in.attiead.notice.application.port.in.RemoveNoticeUseCase;
import in.attiead.notice.application.port.out.RemoveNoticePort;
import in.attiead.notice.domain.Notice.NoticeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RemoveNoticeService implements RemoveNoticeUseCase {

    private final RemoveNoticePort removeNoticePort;

    @Override
    @Transactional
    public void removeNotice(Long nId) {
        NoticeId noticeId = new NoticeId(nId);
        removeNoticePort.deleteNotice(noticeId);
    }
}
