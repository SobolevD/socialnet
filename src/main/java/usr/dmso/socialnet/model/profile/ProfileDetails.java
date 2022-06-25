package usr.dmso.socialnet.model.profile;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "profile_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDetails {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "status")
    private String status;

    @Column(name = "verified")
    private boolean verified;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    @OneToOne
    @MapsId
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfileDetails that = (ProfileDetails) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
