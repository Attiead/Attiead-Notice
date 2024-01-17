package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.domain.NoticeCategory;
import in.attiead.notice.domain.NoticeState;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
public class NoticeJpaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Content content;

    @Enumerated(EnumType.STRING)
    @Column(name = "notice_category")
    private NoticeCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "notice_state")
    private NoticeState state;

    @OneToMany(mappedBy = "noticeJpaEntity", cascade = CascadeType.ALL)
    private List<AttachmentJpaEntity> attachments = new ArrayList<>();

}
