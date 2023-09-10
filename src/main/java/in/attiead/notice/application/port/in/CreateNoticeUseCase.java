package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.CreateNoticeRequestDto;

public interface CreateNoticeUseCase {

    void createNotice(CreateNoticeRequestDto createNoticeRequestDto);
}
