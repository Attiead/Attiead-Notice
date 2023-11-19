package in.attiead.notice.adapter.in.dto;

import in.attiead.notice.domain.NoticeContent;
import jakarta.validation.constraints.NotBlank;

public record NoticeCreateRequestDTO(
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
