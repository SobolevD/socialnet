package usr.dmso.socialnet.model.profile.additional;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profile_work_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileWorkDetails {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "work_place")
    private String workPlace;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "year_of_start")
    private Integer yearOfStart;

    @Column(name = "year_of_end")
    private Integer yearOfEnd;

    @Column(name = "post")
    private String post;

    @OneToOne
    @MapsId
    @JoinColumn(name = "additional_profile_details_id")
    private AdditionalProfileDetails additionalProfileDetails;
}
