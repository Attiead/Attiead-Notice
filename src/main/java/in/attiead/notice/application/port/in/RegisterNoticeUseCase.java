package in.attiead.notice.application.port.in;

import org.springframework.stereotype.Component;

@Component
public interface RegisterNoticeUseCase {

    boolean register(RegisterNoticeCommand command);
}
