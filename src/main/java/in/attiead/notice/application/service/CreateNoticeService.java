package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.CreateNoticeRequestDto;
import in.attiead.notice.application.port.in.CreateNoticeUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateNoticeService implements CreateNoticeUseCase {

    private final CreateNoticePort createNoticePort;

    @Transactional
    @Override
    public void createNotice(CreateNoticeRequestDto createNoticeRequestDto) {
        Notice newNotice = Notice.withoutLongId(createNoticeRequestDto.mapToNoticeContent());
        createNoticePort.createNotice(newNotice);
    }
}
