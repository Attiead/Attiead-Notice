package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDTO;
import in.attiead.notice.adapter.in.dto.NoticeUpdateRequestDTO;
import in.attiead.notice.adapter.out.persistence.NoticeMapper;
import in.attiead.notice.application.port.in.NoticeInfoUseCase;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.application.port.out.GetNoticeInfoPort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeContent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoticeInfoServiceInfo implements NoticeInfoUseCase {

  private final GetNoticeInfoPort getNoticeInfoPort;
  private final CreateNoticePort createNoticePort;
  private final NoticeMapper noticeMapper;

  @Transactional(readOnly = true)
  @Override
  public NoticeInfoResponseDTO getNoticeInfo(Long nid) {
    Notice.NoticeId noticeId = new Notice.NoticeId(nid);
    Notice notice = getNoticeInfoPort.getNoticeByNoticeId(noticeId);
    return noticeMapper.mapToNoticeInfoResponseDto(notice);
  }

  @Transactional(readOnly = true)
  @Override
  public Page<NoticeInfoResponseDTO> getNotices(Pageable pageable) {
    return getNoticeInfoPort.getNotices(pageable);
  }

  @Transactional
  @Override
  public void updateNoticeInfo(
          NoticeUpdateRequestDTO updateRequestDto
  ) {
    Notice.NoticeId noticeId = new Notice.NoticeId(updateRequestDto.nid());
    Notice notice = getNoticeInfoPort.getNoticeByNoticeId(noticeId);
    notice.updateNoticeInfo(
            new NoticeContent(
                    updateRequestDto.title(),
                    updateRequestDto.content(),
                    notice.getContent().author()
            ),
            updateRequestDto.category(),
            updateRequestDto.state()
    );
    createNoticePort.saveNotice(notice);
  }
}
