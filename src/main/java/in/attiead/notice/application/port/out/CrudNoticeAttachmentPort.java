package in.attiead.notice.application.port.out;

import in.attiead.notice.domain.NoticeAttachment;
import java.util.List;

public interface CrudNoticeAttachmentPort {

  void saveNoticeAttachment(List<NoticeAttachment> noticeAttachments);

  void deleteNoticeAttachment(Long noticeAttachmentId);
}
