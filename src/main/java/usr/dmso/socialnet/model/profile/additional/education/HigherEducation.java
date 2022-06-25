package usr.dmso.socialnet.model.profile.additional.education;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "higher_education")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HigherEducation {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "institution_address")
    private String institutionAddress;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "faculty")
    private String faculty;

    @Enumerated(EnumType.STRING)
    @Column(name = "training_form")
    private TrainingForm trainingForm;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "release_date")
    private Integer releaseDate;

    @ManyToOne
    @JoinColumn(name="profile_education_id")
    private ProfileEducation profileEducation;

    public enum TrainingForm {
        FULL_TIME_STUDY,
        FULL_TIME_AND_PART_TIME_WORK,
        PART_TIME_WORK,
        EXTERNAL_STUDY,
        REMOTE_OPERATION
    }

    public enum Status {
        ENTRANT,
        STUDENT_SPECIALIST,
        STUDENT_BACHELOR,
        STUDENT_MASTER,
        GRADUATE_SPECIALIST,
        GRADUATE_BACHELOR,
        GRADUATE_MASTER,
        GRADUATE_STUDENT,
        CANDIDATE_OF_SCIENCES,
        DOCTOR_OF_SCIENCE,
        INTERN,
        CLINICAL_RESIDENT,
        JOB_SEEKER,
        TRAINEE_ASSISTANT,
        DOCTORAL_STUDENT,
        ASSOCIATE_PROFESSOR,
        RESEARCHER
    }
}
