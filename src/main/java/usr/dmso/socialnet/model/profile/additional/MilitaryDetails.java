package usr.dmso.socialnet.model.profile.additional;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profile_military_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MilitaryDetails {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "country")
    private String country;

    @Column(name = "military_unit")
    private String militaryUnit;

    @Column(name = "year_of_start")
    private Integer yearOfStart;

    @Column(name = "year_of_end")
    private Integer yearOfEnd;

    @OneToOne
    @MapsId
    @JoinColumn(name = "additional_profile_details_id")
    private AdditionalProfileDetails additionalProfileDetails;
}
