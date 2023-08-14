package in.attiead.notice.application.service;

import in.attiead.notice.application.port.in.CreateNoticeRequestDto;
import in.attiead.notice.application.port.in.CreateNoticeUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.Notice;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateNoticeService implements CreateNoticeUseCase {

    private Notice notice;
    private CreateNoticePort createNoticePort;

    @Transactional
    @Override
    public void createNotice(CreateNoticeRequestDto createNoticeRequestDto) {
        Notice newNotice = Notice.withId(
                createNoticeRequestDto.getNoticeId(),
                createNoticeRequestDto.getNoticeContent(),
                createNoticeRequestDto.getNoticeState(),
                createNoticeRequestDto.noticeCategory()
        );
        createNoticePort.createNotice(newNotice);
    }

}
