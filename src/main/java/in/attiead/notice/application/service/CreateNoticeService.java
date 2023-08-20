package in.attiead.notice.application.service;

import in.attiead.notice.application.port.in.CreateNoticeRequestDto;
import in.attiead.notice.application.port.in.CreateNoticeUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.Notice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateNoticeService implements CreateNoticeUseCase {

    private Notice notice;
    private CreateNoticePort createNoticePort;

    @Transactional
    @Override
    public void createNotice(CreateNoticeRequestDto createNoticeRequestDto) {
        Notice newNotice = Notice.withId(
                notice.getNoticeId(),
                createNoticeRequestDto.mapToNoticeContent()
        );
        createNoticePort.createNotice(newNotice);
    }

}
