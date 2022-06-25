package usr.dmso.socialnet.model.profile.additional.education;

import lombok.*;
import usr.dmso.socialnet.model.profile.additional.AdditionalProfileDetails;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profile_education")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileEducation {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy="profileEducation")
    private List<SecondaryAndAdditionalEducation> secondaryAndAdditionalEducations;

    @OneToMany(mappedBy="profileEducation")
    private List<HigherEducation> higherEducations;

    @OneToOne
    @MapsId
    @JoinColumn(name = "additional_profile_details_id")
    private AdditionalProfileDetails additionalProfileDetails;
}
