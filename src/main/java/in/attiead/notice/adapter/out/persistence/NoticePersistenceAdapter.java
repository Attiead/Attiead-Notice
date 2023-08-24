package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.application.port.out.UpdateNoticeStatePort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeState;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
class NoticePersistenceAdapter implements
        CreateNoticePort,
        UpdateNoticeStatePort {

    private NoticeRepository noticeRepository;
    private NoticeMapper noticeMapper;

    @Override
    public void createNotice(Notice notice) {
        NoticeJpaEntity noticeJpaEntity = noticeMapper.mapToJpaEntity(notice);
        noticeRepository.save(noticeJpaEntity);
    }

    @Override
    public Notice updateNoticeState(NoticeState noticeState) {
        return null;
    }
}
