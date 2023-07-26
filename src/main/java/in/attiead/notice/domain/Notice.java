package in.attiead.notice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@AttributeOverride(name = "id", column = @Column(name = "notice_id", updatable = false))
@NoArgsConstructor
@Getter
public class Notice extends BaseEntity {

    @Column(name = "notice_title", length = 30, nullable = false)
    private String title;

    @Column(name = "notice_content", length = 1000, nullable = false)
    private String content;

    @Column(name = "notice_author", length = 10, nullable = false)
    private String author;

    @OneToMany
    @Column(name = "notice_attachments")
    private List<Attachment> attachments;

    @Enumerated(EnumType.STRING)
    @Column(name = "notice_state")
    private NoticeState state;

    // register notice

    // update notice state
}
