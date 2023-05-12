package fuel.gymgenie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "equipments")
@NoArgsConstructor
@Getter @Setter @ToString
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private long id;

    @Column(nullable = false, length = 25)
    private String label;

    @Column(nullable = false)
    private Date purchasedOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    @ToString.Exclude
    private EquipmentType type;
}
