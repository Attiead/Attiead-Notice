package in.attiead.notice.application.port.in;

import in.attiead.notice.adapter.in.dto.NoticeCreateRequestDTO;
import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface NoticeCreateUseCase {

    void createNotice(NoticeCreateRequestDTO noticeCreateRequestDTO, List<MultipartFile> files);
}
