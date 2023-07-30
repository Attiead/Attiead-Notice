package in.attiead.notice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@AttributeOverride(name = "id", column = @Column(name = "id", updatable = false))
public class Attachment extends BaseEntity{

    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "notice_id")
    private Notice notice;

}
