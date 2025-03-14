package in.attiead.notice.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileExceptionMessages {

  FAIL_TO_SAVE_DATA("Failed to save file");

  private final String message;
}
