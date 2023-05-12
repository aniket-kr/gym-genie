package fuel.gymgenie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@Getter @Setter @ToString
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 15)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private BloodGroup bloodGroup;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Member member;
}
