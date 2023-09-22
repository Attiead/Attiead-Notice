package in.attiead.notice.application.port.out;

import in.attiead.notice.domain.Notice;
import java.util.List;

public interface RetrieveNoticeInfoPort {

    Notice retrieveSingleNoticeInfo(Notice notice);

    List<Notice> retrieveMultiNoticeInfo(Notice notice);
}
