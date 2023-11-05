package in.attiead.notice.common.exception;

import in.attiead.notice.common.MetaCode;

public class NotFoundException extends BaseHttpException {

  public static final String NOT_FOUND_JPAENTITY = "noticeJpaEntity not found";

  public NotFoundException(String message) {
    super(MetaCode.NOT_FOUND, message, null);
  }

  public NotFoundException(String message, Object data) {
    super(MetaCode.NOT_FOUND, message, data);
  }
}
