package in.attiead.notice.common.exception;

import in.attiead.notice.common.MetaCode;

public class ConflictException extends BaseHttpException {

  public ConflictException(String message, Object data) {
    super(MetaCode.CONFLICT, message, data);
  }
}
