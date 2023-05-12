package fuel.gymgenie.repository;

import fuel.gymgenie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "select * from member_roles where name = :name limit 1", nativeQuery = true)
    public Role findByName(@Param("name") String name);
}
