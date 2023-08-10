package in.attiead.notice.adapter.in.web;

import in.attiead.notice.application.port.in.RegisterNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterNoticeUseCase registerNoticeUseCase;

    /**
     * register
     * 등록 요청
     */

    /**
     * get - notice list (flux)
     * n개 조회
     */

    /**
     * get - notice list (mono)
     * 단일 조회
     */

    /**
     * post
     * notice update
     */

}
