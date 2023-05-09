package fuel.gymgenie.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profileId")
    private long id;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(length = 40)
    private String lastName;

    @Column(nullable = false, length = 15)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private BloodGroup bloodGroup;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private Member member;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
