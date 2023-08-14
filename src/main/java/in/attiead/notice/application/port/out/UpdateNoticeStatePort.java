package in.attiead.notice.application.port.out;

import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeState;

public interface UpdateNoticeStatePort {

    Notice updateNoticeState(NoticeState noticeState);
}
