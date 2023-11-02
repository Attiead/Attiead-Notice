package in.attiead.notice.application.service;

import in.attiead.notice.application.port.in.NoticeRemoveUseCase;
import in.attiead.notice.application.port.out.RemoveNoticePort;
import in.attiead.notice.domain.Notice.NoticeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeRemoveService implements NoticeRemoveUseCase {

    private final RemoveNoticePort removeNoticePort;

    @Override
    @Transactional
    public void removeNotice(Long nid) {
        NoticeId noticeId = new NoticeId(nid);
        removeNoticePort.deleteNotice(noticeId);
    }
}
