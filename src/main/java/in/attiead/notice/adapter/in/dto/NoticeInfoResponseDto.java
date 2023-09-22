package in.attiead.notice.adapter.in.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record NoticeInfoResponseDto(

        @NotNull Long id,
        @NotNull String title,
        @NotNull String content,
        @NotNull String author,
        @NotNull String category,
        @NotNull String state,
        @NotNull LocalDateTime createdAt,
        @NotNull LocalDateTime updateAt
) {
}
