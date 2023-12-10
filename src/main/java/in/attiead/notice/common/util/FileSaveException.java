package in.attiead.notice.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileSaveException {

  FAIL_TO_SAVA_DATA("Failed to save file");

  private final String message;
}
