package in.attiead.notice.application.port.out;

import in.attiead.notice.common.AbstractResponseDto;
import in.attiead.notice.common.Meta;
import in.attiead.notice.common.MetaCode;
import lombok.Getter;

@Getter
public class ResponseDto<T> extends AbstractResponseDto<T> {

    private final Meta meta;
    private final T data;

    public ResponseDto(Meta meta, T data) {
        super(meta, data);
        this.meta = meta;
        this.data = data;
    }

    public static <T> ResponseDto<T> success(Meta meta, T data) {
        return new ResponseDto<>(meta, data);
    }

    public static <T> ResponseDto<T> success(MetaCode metaCode, T data) {
        return success(new Meta(metaCode), data);
    }

    public static <T> ResponseDto<T> success(T data) {
        return success(MetaCode.SUCCESS, data);
    }
}
