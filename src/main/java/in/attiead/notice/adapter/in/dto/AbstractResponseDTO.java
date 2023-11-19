package in.attiead.notice.adapter.in.dto;

import in.attiead.notice.common.Meta;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class AbstractResponseDTO<T> {

  private final Meta meta;
  private final T data;

}
