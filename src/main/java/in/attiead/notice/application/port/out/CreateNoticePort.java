package in.attiead.notice.application.port.out;

import in.attiead.notice.domain.Notice;

/**
 * save 로 변경 권장
 */
public interface CreateNoticePort {

    void saveNotice(Notice notice);
}
