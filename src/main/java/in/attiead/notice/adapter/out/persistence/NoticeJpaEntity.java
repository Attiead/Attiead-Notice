package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.domain.NoticeCategory;
import in.attiead.notice.domain.NoticeState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
public class NoticeJpaEntity extends BaseEntity {
    @Id
    private Long id;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "content", length = 1000, nullable = false)
    private String content;

    @Column(name = "author", length = 10, nullable = false)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "notice_category")
    private NoticeCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "notice_state")
    private NoticeState state;

}
