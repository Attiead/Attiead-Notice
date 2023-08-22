package in.attiead.notice.adapter.in.web;

import in.attiead.notice.application.port.in.CreateNoticeRequestDto;
import in.attiead.notice.application.port.in.CreateNoticeUseCase;
import in.attiead.notice.application.port.out.ResponseDto;
import in.attiead.notice.common.MetaCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 책임
 * HTTP 요청을 자바 객체로 매핑
 * 권한 검사
 * 입력 유효성 검증
 * 입력을 유스케이스의 입력 모델로 매핑
 * 유스케이스 호출
 * 유스케이스의 출력을 HTTP로 매핑
 * HTTP 응답을 반환
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notices")
class NoticeCreateController {

    private final CreateNoticeUseCase createNoticeUseCase;

    @PostMapping
    public ResponseDto<MetaCode> createNotice(@Valid @RequestBody CreateNoticeRequestDto createNoticeRequestDto) {
        createNoticeUseCase.createNotice(createNoticeRequestDto);
        return ResponseDto.success(MetaCode.SUCCESS);
    }
}

