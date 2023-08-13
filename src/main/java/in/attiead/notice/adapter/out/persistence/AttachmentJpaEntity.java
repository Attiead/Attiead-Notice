package in.attiead.notice.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
public class AttachmentJpaEntity extends BaseEntity {
    @Id
    private Long id;

    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "notice_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private NoticeJpaEntity noticeJpaEntity;

}
