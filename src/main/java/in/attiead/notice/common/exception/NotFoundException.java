package in.attiead.notice.common.exception;

import in.attiead.notice.common.MetaCode;

public class NotFoundException extends BaseHttpException {

  public NotFoundException(String message, Object data) {
    super(MetaCode.NOT_FOUND, message, data);
  }

  public NotFoundException(Exception exception) {
    this(exception.getMessage(), null);
  }
}
