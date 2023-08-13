package in.attiead.notice.domain;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public record NoticeContent(String title, String content, String author) {

}
