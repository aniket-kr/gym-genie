package fuel.gymgenie.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipment_types")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_type_id")
    private int id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 600)
    private String description;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Set<Equipment> equipments = new HashSet<>();
}
