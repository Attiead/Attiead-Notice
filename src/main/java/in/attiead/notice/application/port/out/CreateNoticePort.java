package in.attiead.notice.application.port.out;

import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeContent;

public interface CreateNoticePort {

    void registerNotice(Notice notice, NoticeContent noticeContent);
}
