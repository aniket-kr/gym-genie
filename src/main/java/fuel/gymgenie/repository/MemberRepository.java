package fuel.gymgenie.repository;

import fuel.gymgenie.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(@Param("email") String email);
}
