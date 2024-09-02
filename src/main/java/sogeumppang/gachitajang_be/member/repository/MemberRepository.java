package sogeumppang.gachitajang_be.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sogeumppang.gachitajang_be.member.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
