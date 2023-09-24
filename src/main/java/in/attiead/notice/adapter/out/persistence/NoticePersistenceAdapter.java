package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.application.port.out.RemoveNoticePort;
import in.attiead.notice.application.port.out.RetrieveNoticeInfoPort;
import in.attiead.notice.application.port.out.UpdateNoticeStatePort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.Notice.NoticeId;
import in.attiead.notice.domain.NoticeState;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class NoticePersistenceAdapter implements CreateNoticePort, RetrieveNoticeInfoPort,
    UpdateNoticeStatePort, RemoveNoticePort {

  private final NoticeRepository noticeRepository;
  private final NoticeMapper noticeMapper;

  @Override
  public void createNotice(Notice notice) {
    NoticeJpaEntity noticeJpaEntity = noticeMapper.mapToJpaEntity(notice);
    noticeRepository.save(noticeJpaEntity);
  }

  @Override
  public Notice updateNoticeState(NoticeState noticeState) {
    return null;
  }

  @Override
  public void deleteNotice(NoticeId noticeId) {
    noticeRepository.deleteById(noticeId.id());
  }

  @Override
  public Notice retrieveSingleNoticeInfo(Notice notice) {
    Optional<NoticeJpaEntity> noticeJpaEntity = noticeRepository.findById(notice.getNoticeId().id());
    return noticeMapper.mapToDomainEntity(noticeJpaEntity);
  }

  @Override
  public Page<NoticeInfoResponseDto> retrieveMultiNoticeInfo(Pageable pageable) {
    Page<NoticeJpaEntity> noticePageJpaEntity = noticeRepository.findAll(pageable);
    return noticePageJpaEntity.map(noticeMapper::mapToNoticeInfoResponseDto);
  }
}
