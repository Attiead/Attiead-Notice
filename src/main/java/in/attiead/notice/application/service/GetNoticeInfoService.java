package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.adapter.out.persistence.NoticeMapper;
import in.attiead.notice.application.port.in.GetNoticeUseCase;
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
public class GetNoticeInfoService implements GetNoticeUseCase {

  private final GetNoticeInfoPort getNoticeInfoPort;
  private final NoticeMapper noticeMapper;

  @Override
  public NoticeInfoResponseDto getSingleNoticeInfo(Long nId) {
    Notice.NoticeId noticeId = new Notice.NoticeId(nId);
    Notice notice = getNoticeInfoPort.getNotice(noticeId);
    return noticeMapper.mapToNoticeInfoResponseDto(notice);
  }



  @Override
  public Page<NoticeInfoResponseDto> getNotices(Pageable pageable) {
    return getNoticeInfoPort.getNotices(pageable);
  }
}
