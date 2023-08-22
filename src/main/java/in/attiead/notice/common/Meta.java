package in.attiead.notice.common;

import lombok.Getter;

@Getter
public class Meta {

    private final MetaCode code;
    private final String type;
    private final String message;

    public Meta(MetaCode code, String type, String message) {
        this.code = code;
        this.type = type == null ? code.name() : type;
        this.message = message;
    }

    public Meta(MetaCode code, String type) {
        this.code = code;
        this.type = (type == null) ? code.name() : type;
        this.message = null;
    }

    public Meta(MetaCode code) {
        this.code = code;
        this.type = code.name();
        this.message = null;
    }
}
