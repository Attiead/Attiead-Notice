package in.attiead.notice.application.port.out;

import in.attiead.notice.adapter.out.persistence.NoticeJpaEntity;
import in.attiead.notice.domain.Notice;

public interface CreateNoticePort {

    NoticeJpaEntity saveNotice(Notice notice);
}
