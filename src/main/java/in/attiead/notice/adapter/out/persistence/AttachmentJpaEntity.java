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

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "notice_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private NoticeJpaEntity noticeJpaEntity;

}
