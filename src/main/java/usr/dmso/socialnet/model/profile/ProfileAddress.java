package usr.dmso.socialnet.model.profile;

import lombok.*;
import org.hibernate.Hibernate;
import usr.dmso.socialnet.model.profile.additional.AdditionalProfileDetails;
import usr.dmso.socialnet.model.profile.additional.ProfileContacts;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "profile_address")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileAddress {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "flat_number")
    private String flatNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfileAddress that = (ProfileAddress) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "profile_contacts_id")
    private ProfileContacts profileContacts;
}
