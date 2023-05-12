package fuel.gymgenie.repository;

import fuel.gymgenie.entity.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Integer> {
}
