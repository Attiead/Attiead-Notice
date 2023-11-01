package in.attiead.notice.adapter.in.dto;

import in.attiead.notice.domain.NoticeCategory;
import in.attiead.notice.domain.NoticeState;
import jakarta.annotation.Nullable;

public record NoticeUpdateRequestDto(

        long nid,
        @Nullable String title,
        @Nullable String content,
        @Nullable NoticeCategory category,
        @Nullable NoticeState state

) {
}
