package usr.dmso.socialnet.model.profile.additional;

import lombok.*;
import usr.dmso.socialnet.model.profile.Profile;
import usr.dmso.socialnet.model.profile.ProfileAddress;

import javax.persistence.*;
import java.net.URL;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profile_contacts")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileContacts {

    @Id
    @Column(name = "id")
    private UUID id;

    @ElementCollection
    @CollectionTable(name="phone_numbers", joinColumns=@JoinColumn(name="profile_contact_id"))
    private List<String> phoneNumbers;

    @ElementCollection
    @CollectionTable(name="email_addresses", joinColumns=@JoinColumn(name="profile_contact_id"))
    private List<String> emailAddresses;

    @Column(name = "instagram")
    private URL instagram;

    @Column(name = "skype")
    private String skype;

    @Column(name = "site")
    private URL site;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProfileAddress address;

    @OneToOne
    @MapsId
    @JoinColumn(name = "additional_profile_details_id")
    private AdditionalProfileDetails additionalProfileDetails;
}
