package in.attiead.notice.common.exception;

import in.attiead.notice.common.MetaCode;

public class InternalServerException extends BaseHttpException {

  public InternalServerException(String message, Object data) {
    super(MetaCode.INTERNAL_SERVER_ERROR, message, data);
  }

  public InternalServerException(String message) {
    super(MetaCode.INTERNAL_SERVER_ERROR, message, null);
  }
}
