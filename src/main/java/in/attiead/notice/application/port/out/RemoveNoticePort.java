package in.attiead.notice.application.port.out;

import in.attiead.notice.domain.Notice;

public interface RemoveNoticePort {

    void deleteNotice(Notice notice);
}
