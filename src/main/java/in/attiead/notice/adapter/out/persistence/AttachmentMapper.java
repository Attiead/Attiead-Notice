package in.attiead.notice.adapter.out.persistence;

import in.attiead.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttachmentMapper {
  //todo
  AttachmentJpaEntity mapToAttachmentJpaEntity(Notice notice) {
    return AttachmentJpaEntity.builder()
        .build();
  }

}
