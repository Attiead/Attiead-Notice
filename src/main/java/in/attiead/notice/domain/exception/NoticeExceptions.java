package in.attiead.notice.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeExceptions {

    NOT_FOUND_JPA_ENTITY("noticeJpaEntity not found");

    private final String message;

}
