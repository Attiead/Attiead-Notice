package in.attiead.notice.domain;

import lombok.Value;

public class Notice {

    private NoticeId id;

    @Value
    public static class NoticeId {
        Long value;
    }
}

