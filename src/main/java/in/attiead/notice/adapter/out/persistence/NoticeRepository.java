package in.attiead.notice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface NoticeRepository extends JpaRepository<NoticeJpaEntity, Long> {

}
