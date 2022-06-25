package usr.dmso.socialnet.model.profile.additional.education;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "secondary_education")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecondaryAndAdditionalEducation {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "school_address")
    private String schoolAddress;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "year_of_beginning")
    private Integer yearOfBeginning;

    @Column(name = "year_of_graduation")
    private Integer yearOfGraduation;

    @Column(name = "class_name")
    private String className;

    @Column(name = "specialization")
    private String specialization;

    @ManyToOne
    @JoinColumn(name="profile_education_id")
    private ProfileEducation profileEducation;
}
