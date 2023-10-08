package in.attiead.notice.common.exception;

import in.attiead.notice.common.MetaCode;

public class InvalidException extends BaseHttpException {

  public InvalidException(MetaCode metaCode, String message, Object data) {
    super(metaCode, message, data);
  }
}
