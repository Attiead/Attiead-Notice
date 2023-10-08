package in.attiead.notice.common.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Log {

  default Logger getLogger() {
    return LoggerFactory.getLogger(this.getClass());
  }
}
