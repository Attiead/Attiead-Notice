package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.out.persistence.NoticeMapper;
import in.attiead.notice.application.port.in.NoticeInfoUseCase;
import in.attiead.notice.application.port.out.GetNoticeInfoPort;
import in.attiead.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeInfoServiceInfo implements NoticeInfoUseCase {

  private final GetNoticeInfoPort getNoticeInfoPort;
  private final NoticeMapper noticeMapper;

  @Override
  public NoticeInfoResponseDto getNoticeInfo(Long nId) {
    Notice singleNotice = Notice.onlyId(nId);
    Notice notice = getNoticeInfoPort.getNoticeInfo(singleNotice);

    return noticeMapper.mapToNoticeInfoResponseDto(notice);
  }

  @Override
  public Page<NoticeInfoResponseDto> getNotices(Pageable pageable) {
    return getNoticeInfoPort.getNotices(pageable);
  }
}
