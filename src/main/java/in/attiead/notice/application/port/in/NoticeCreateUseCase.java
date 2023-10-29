package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDto;

public interface NoticeCreateUseCase {

    void createNotice(NoticeCreateRequestDto noticeCreateRequestDto);
}
