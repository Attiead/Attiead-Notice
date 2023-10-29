package in.attiead.notice.adapter.in.web;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDto;
import in.attiead.notice.application.port.in.NoticeCreateUseCase;
import in.attiead.notice.adapter.in.dto.ResponseDto;
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

    private final NoticeCreateUseCase noticeCreateUseCase;

    @PostMapping
    public ResponseDto<Void> createNotice(@Valid @RequestBody NoticeCreateRequestDto noticeCreateRequestDto) {
        noticeCreateUseCase.createNotice(noticeCreateRequestDto);
        return ResponseDto.success(null);
    }
}

