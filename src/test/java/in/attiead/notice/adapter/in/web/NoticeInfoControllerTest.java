package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.in.dto.NoticeUpdateRequestDto;
import in.attiead.notice.application.port.in.NoticeInfoUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeInfoControllerTest {

    @Autowired
    private CreateNoticePort createNoticePort;

    @Autowired
    private NoticeInfoUseCase noticeInfoUseCase;

    @Test
    @Transactional
    void updateNoticeInfo() {
        Notice newNotice = Notice.builder()
                .noticeId(
                        new Notice.NoticeId(10L)
                )
                .noticeContent(
                        new NoticeContent(
                                "수정전 제목입니다",
                                "수정전 내용입니다",
                                "글쓴이1"
                        )
                )
                .noticeState(NoticeState.ACTIVE)
                .noticeCategory(NoticeCategory.OPERATE)
                .noticeTimeInfo(new NoticeTimeInfo())
                .build();
        createNoticePort.saveNotice(newNotice);

        // when
        noticeInfoUseCase.updateNoticeInfo(
                new NoticeUpdateRequestDto(
                        10L,
                        "수정후 제목입니다",
                        "수정후 내용입니다",
                        NoticeCategory.MANAGEMENT,
                        NoticeState.STANDBY
                )
        );
        NoticeInfoResponseDto noticeInfo = noticeInfoUseCase.getNoticeInfo(10L);

        // then
        Assertions.assertEquals(10L, noticeInfo.id());
        Assertions.assertEquals("수정후 제목입니다", noticeInfo.title());
        Assertions.assertEquals("수정후 내용입니다", noticeInfo.content());
        Assertions.assertEquals(String.valueOf(NoticeCategory.MANAGEMENT), noticeInfo.category());
        Assertions.assertEquals(String.valueOf(NoticeState.STANDBY), noticeInfo.state());
    }
}
