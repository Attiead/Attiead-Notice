package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import org.springframework.web.multipart.MultipartFile;

public interface NoticeCreateUseCase {

    void createNotice(NoticeCreateRequestDTO noticeCreateRequestDTO, MultipartFile files);
}
