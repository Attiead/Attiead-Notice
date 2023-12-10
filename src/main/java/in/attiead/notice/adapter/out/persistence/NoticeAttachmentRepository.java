package in.attiead.notice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface NoticeAttachmentRepository extends JpaRepository<AttachmentJpaEntity, Long> {

}
