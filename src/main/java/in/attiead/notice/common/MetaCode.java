package in.attiead.notice.common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MetaCode {

    SUCCESS("20000000"),
    CREATED("20100000"),
    ACCEPTED("20200000"),
    NO_CONTENT("20400000"),
    BAD_REQUEST("40000000"),
    AUTHENTICATION_FAILED("40100000"),
    FORBIDDEN("40300000"),
    NOT_FOUND("40400000"),
    METHOD_NOW_ALLOWED("40500000"),
    NOT_ACCEPTABLE("40600000"),
    CONFLICT("40900000"),
    UNSUPPORTED_MEDIA_TYPE("41500000"),
    UNPROCESSABLE_ENTITY("42200000"),
    THROTTLED("42900000"),
    INTERNAL_SERVER_ERROR("50000000"),
    NOT_IMPLEMENTED("50100000"),
    SERVICE_UNAVAILABLE("50300000");

    private static final String DEFAULT_META_CODE = "00000";
    private final String code;

    public static MetaCode valueFrom(HttpStatus status) {
        switch (status) {
            case OK -> {
                return SUCCESS;
            }
            case CREATED -> {
                return CREATED;
            }
            case NO_CONTENT -> {
                return NO_CONTENT;
            }
            case BAD_REQUEST -> {
                return BAD_REQUEST;
            }
            case NOT_FOUND -> {
                return NOT_FOUND;
            }
            case CONFLICT -> {
                return CONFLICT;
            }
            case NOT_IMPLEMENTED -> {
                return NOT_IMPLEMENTED;
            }
            case INTERNAL_SERVER_ERROR -> {
                return INTERNAL_SERVER_ERROR;
            }
            case SERVICE_UNAVAILABLE -> {
                return SERVICE_UNAVAILABLE;
            }
            case UNPROCESSABLE_ENTITY -> {
                return UNPROCESSABLE_ENTITY;
            }
            default -> throw new IllegalArgumentException("Please provide correct status.");
        }
    }
}
