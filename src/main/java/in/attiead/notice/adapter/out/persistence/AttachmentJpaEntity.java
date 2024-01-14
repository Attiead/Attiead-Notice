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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "server_file_name")
    private String serverFileName;

    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "notice_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private NoticeJpaEntity noticeJpaEntity;

    public void updateNoticeAttachment(
        NoticeJpaEntity noticeJpaEntity
    ) {
        if(this.noticeJpaEntity != null) {
            this.noticeJpaEntity.getAttachments().remove(this);
        }
        this.noticeJpaEntity = noticeJpaEntity;
        this.noticeJpaEntity.getAttachments().add(this);
    }
}
