package in.attiead.notice.application.port.out;

import in.attiead.notice.domain.Notice.NoticeId;

public interface RemoveNoticePort {

    void deleteNotice(NoticeId noticeId);
}
