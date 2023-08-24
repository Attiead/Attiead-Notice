package in.attiead.notice.application.port.in;

import org.springframework.stereotype.Component;

@Component
public interface CreateNoticeUseCase {

    void createNotice(CreateNoticeRequestDto createNoticeRequestDto);
}
