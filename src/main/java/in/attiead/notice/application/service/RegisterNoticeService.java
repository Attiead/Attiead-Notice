package in.attiead.notice.application.service;

import in.attiead.notice.application.port.in.RegisterNoticeCommand;
import in.attiead.notice.application.port.in.RegisterNoticeUseCase;
import in.attiead.notice.domain.Notice;
import org.springframework.stereotype.Service;

@Service
public class RegisterNoticeService implements RegisterNoticeUseCase {

    private Notice notice;

    @Override
    public boolean register(RegisterNoticeCommand command) {
        return false;
    }
}
