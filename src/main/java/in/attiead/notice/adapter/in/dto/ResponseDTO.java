package in.attiead.notice.adapter.in.dto;

import in.attiead.notice.common.Meta;
import in.attiead.notice.common.MetaCode;
import lombok.Getter;

@Getter
public class ResponseDTO<T> extends AbstractResponseDTO<T> {

    private final Meta meta;
    private final T data;

    public ResponseDTO(Meta meta, T data) {
        super(meta, data);
        this.meta = meta;
        this.data = data;
    }

    public static <T> ResponseDTO<T> success(Meta meta, T data) {
        return new ResponseDTO<>(meta, data);
    }

    public static <T> ResponseDTO<T> success(MetaCode metaCode, T data) {
        return success(new Meta(metaCode), data);
    }

    public static <T> ResponseDTO<T> success(T data) {
        return success(MetaCode.SUCCESS, data);
    }
}
