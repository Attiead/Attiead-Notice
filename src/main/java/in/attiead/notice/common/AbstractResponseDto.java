package in.attiead.notice.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class AbstractResponseDto<T> {

    private final Meta meta;
    private final T data;

}
