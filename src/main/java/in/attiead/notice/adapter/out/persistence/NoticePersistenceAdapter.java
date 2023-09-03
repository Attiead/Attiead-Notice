package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.application.port.out.RemoveNoticePort;
import in.attiead.notice.application.port.out.RetrieveNoticeInfoPort;
import in.attiead.notice.application.port.out.UpdateNoticeStatePort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class NoticePersistenceAdapter implements
        CreateNoticePort,
        RetrieveNoticeInfoPort,
        UpdateNoticeStatePort,
        RemoveNoticePort {

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
    public void deleteNotice(Notice notice) {
        noticeRepository.deleteById(notice.getNoticeId().id());
    }

    @Override
    public Notice retrieveSingleNoticeInfo(Notice notice) {
        Optional<NoticeJpaEntity> noticeJpaEntity = noticeRepository.findById(notice.getNoticeId().id());
        return null;

    }

    @Override
    public List<Notice> retrieveMultiNoticeInfo(Notice notice) {
        return null;
    }
}
