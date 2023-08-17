package in.attiead.notice.application.port.in;

import in.attiead.notice.domain.Notice.NoticeId;
import in.attiead.notice.domain.NoticeCategory;
import in.attiead.notice.domain.NoticeContent;
import in.attiead.notice.domain.NoticeState;
import jakarta.validation.constraints.NotBlank;


public record CreateNoticeRequestDto(
        @NotBlank NoticeId noticeId,
        @NotBlank NoticeContent noticeContent,
        @NotBlank NoticeCategory noticeCategory,
        @NotBlank NoticeState noticeState
) {

}

