package in.attiead.notice.common.exception;

import in.attiead.notice.common.MetaCode;
import in.attiead.notice.domain.exception.NoticeExceptions;

public class NotFoundException extends BaseHttpException {

  public NotFoundException(String message) {
    super(MetaCode.NOT_FOUND, message, null);
  }

  public NotFoundException(String message, Object data) {
    super(MetaCode.NOT_FOUND, message, data);
  }

  public NotFoundException(NoticeExceptions noticeExceptions) {
  }
}
