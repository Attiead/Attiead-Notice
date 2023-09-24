package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.out.persistence.NoticeMapper;
import in.attiead.notice.application.port.in.RetrieveNoticeUseCase;
import in.attiead.notice.application.port.out.RetrieveNoticeInfoPort;
import in.attiead.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveNoticeInfoService implements RetrieveNoticeUseCase {

  private final RetrieveNoticeInfoPort retrieveNoticeInfoPort;
  private final NoticeMapper noticeMapper;

  @Override
  public NoticeInfoResponseDto retrieveSingleNoticeInfo(Long nId) {
    Notice singleNotice = Notice.withLongId(nId);
    Notice notice = retrieveNoticeInfoPort.retrieveSingleNoticeInfo(singleNotice);

    return noticeMapper.mapToNoticeInfoResponseDto(notice);
  }

  @Override
  public Page<NoticeInfoResponseDto> retrieveMultiNoticeInfo(Pageable pageable) {
    return retrieveNoticeInfoPort.retrieveMultiNoticeInfo(pageable);
  }
}
