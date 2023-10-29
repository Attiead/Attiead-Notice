package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDto;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeCreateService implements NoticeCreateUseCase {

    private final CreateNoticePort createNoticePort;

    @Override
    @Transactional
    public void createNotice(NoticeCreateRequestDto noticeCreateRequestDto) {
        Notice newNotice = Notice.withoutId(noticeCreateRequestDto.mapToNoticeContent());
        createNoticePort.createNotice(newNotice);
    }
}
