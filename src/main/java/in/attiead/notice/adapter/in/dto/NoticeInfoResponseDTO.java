package in.attiead.notice.adapter.in.dto;

import in.attiead.notice.domain.NoticeAttachment;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

@Builder
public record NoticeInfoResponseDTO(
        @NotNull Long id,
        @NotNull String title,
        @NotNull String content,
        @NotNull String author,
        @NotNull String category,
        @NotNull String state,
        @NotNull LocalDateTime createdAt,
        @NotNull LocalDateTime updateAt,
        List<NoticeAttachment> noticeAttachments
) {
}
