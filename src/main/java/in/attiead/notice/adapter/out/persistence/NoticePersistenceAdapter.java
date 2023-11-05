package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.adapter.in.dto.NoticeInfoResponseDto;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.application.port.out.GetNoticeInfoPort;
import in.attiead.notice.application.port.out.RemoveNoticePort;
import in.attiead.notice.common.exception.NotFoundException;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.Notice.NoticeId;
import in.attiead.notice.domain.exception.NoticeExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class NoticePersistenceAdapter implements
    CreateNoticePort,
    GetNoticeInfoPort,
    RemoveNoticePort {

  private final NoticeRepository noticeRepository;
  private final NoticeMapper noticeMapper;

  @Override
  public void saveNotice(Notice notice) {
    NoticeJpaEntity noticeJpaEntity = noticeMapper.mapToJpaEntity(notice);
    noticeRepository.save(noticeJpaEntity);
  }

  @Override
  public void deleteNotice(NoticeId noticeId) {
    noticeRepository.deleteById(noticeId.id());
  }

  @Override
  public Notice getNoticeById(NoticeId noticeId) {
    NoticeJpaEntity noticeJpaEntity = noticeRepository
            .findById(noticeId.id())
            .orElseThrow(() -> new NotFoundException(NoticeExceptions.NOT_FOUND_JPA_ENTITY));
    return noticeMapper.mapToDomainEntity(noticeJpaEntity);
  }

  @Override
  public Page<NoticeInfoResponseDto> getNotices(Pageable pageable) {
    Page<NoticeJpaEntity> noticePageJpaEntity = noticeRepository.findAll(pageable);
    return noticePageJpaEntity.map(noticeMapper::mapToNoticeInfoResponseDto);
  }
}
