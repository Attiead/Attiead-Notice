package in.attiead.notice.application.port.in;

import in.attiead.notice.domain.NoticeContent;
import jakarta.validation.constraints.NotBlank;

public record CreateNoticeRequestDto(
        @NotBlank String title,
        @NotBlank String content,
        @NotBlank String author
) {
    public NoticeContent mapToNoticeContent() {
        return new NoticeContent(
                title,
                content,
                author
        );
    }

}

