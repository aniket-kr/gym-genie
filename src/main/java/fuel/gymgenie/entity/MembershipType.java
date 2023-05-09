package fuel.gymgenie.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "membership_types")
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_type_id")
    private long id;

    @Column(nullable = false, length = 25)
    private String title;

    @Column(nullable = false, length = 600)
    private String description;

    @Column(nullable = false, precision = 2)
    private double price;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean isArchived;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Set<Membership> memberships = new HashSet<>();
}
