package in.attiead.notice.common.exception;

import in.attiead.notice.common.MetaCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseHttpException extends RuntimeException {

  private MetaCode metaCode;
  private String message;
  private Object data;

  public BaseHttpException() {
    this(MetaCode.INTERNAL_SERVER_ERROR, null, null);
  }
}
