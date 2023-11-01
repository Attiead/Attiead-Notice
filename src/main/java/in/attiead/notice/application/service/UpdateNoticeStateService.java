package in.attiead.notice.application.service;

import in.attiead.notice.adapter.in.dto.NoticeUpdateRequestDto;
import in.attiead.notice.adapter.out.persistence.NoticeMapper;
import in.attiead.notice.application.port.out.CreateNoticePort;
import in.attiead.notice.application.port.out.GetNoticeInfoPort;
import in.attiead.notice.domain.Notice;
import in.attiead.notice.domain.NoticeContent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateNoticeStateService {

    private final GetNoticeInfoPort getNoticeInfoPort;
    private final CreateNoticePort createNoticePort;
    private final NoticeMapper noticeMapper;

    @Transactional
    public void update(
            NoticeUpdateRequestDto requestDto
    ) {
        Notice notice = getNotice(requestDto);
        notice.updateNoticeInfo(
                new NoticeContent(
                        requestDto.title(),
                        requestDto.content(),
                        notice.getContent().author()
                ),
                requestDto.category(),
                requestDto.state()
        );
        createNoticePort.createNotice(notice);
    }

    private Notice getNotice(
            NoticeUpdateRequestDto requestDto
    ) {
        Notice.NoticeId noticeId = new Notice.NoticeId(requestDto.nid());
        return getNoticeInfoPort.getNotice(noticeId);
    }
}
