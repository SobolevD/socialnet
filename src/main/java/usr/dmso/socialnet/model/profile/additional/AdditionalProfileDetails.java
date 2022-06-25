package usr.dmso.socialnet.model.profile.additional;

import lombok.*;
import usr.dmso.socialnet.model.profile.Profile;
import usr.dmso.socialnet.model.profile.additional.education.ProfileEducation;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "additional_profile_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdditionalProfileDetails {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "home_town")
    private String homeTown;

    @ElementCollection
    @CollectionTable(name="languages", joinColumns=@JoinColumn(name="profile_info_id"))
    private List<String> languages;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProfileContacts profileContacts;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProfileInterests profileInterests;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProfileEducation profileEducation;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProfileWorkDetails profileWorkDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private MilitaryDetails militaryDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProfileLifePosition profileLifePosition;

    @OneToOne
    @MapsId
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
