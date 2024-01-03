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

    @Column(name = "client_file_name")
    private String clientFileName;

    @Column(name = "server_file_name")
    private String serverFileName;

    @ManyToOne
    @JoinColumn(name = "notice_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private NoticeJpaEntity noticeJpaEntity;

}
