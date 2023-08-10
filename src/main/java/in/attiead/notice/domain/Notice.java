package in.attiead.notice.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
public class Notice {

    private NoticeId id;
    private NoticeState state;
    private NoticeCategory category;

    @Value
    public static class NoticeId {
        Long id;
    }
}