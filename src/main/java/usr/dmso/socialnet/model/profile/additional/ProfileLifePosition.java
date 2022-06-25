package usr.dmso.socialnet.model.profile.additional;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profile_life_position")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileLifePosition {
    public enum PoliticalPreference {
        INDIFFERENT_ONES,
        COMMUNIST_ORGANISATIONS,
        SOCIALIST_ORGANISATIONS,
        MODERATE,
        LIBERAL_PROGRAMS,
        CONSERVATIVE_ONES,
        MONARCHICAL_ORGANISATIONS,
        ULTRA_CONSERVATIVE_ONES,
        LIBERTARIAN
    }

    public enum WorldView {
        JUDAISM,
        ORTHODOXY,
        CATHOLICISM,
        PROTESTANTISM,
        ISLAM,
        BUDDHISM,
        CONFUCIANISM,
        SECULAR_HUMANISM,
        PASTAFARIANISM
    }

    public enum MainThingInLife {
        FAMILY_AND_CHILDREN,
        CAREER_AND_MONEY,
        ENTERTAINMENT_AND_RECREATION,
        SCIENCE_AND_RESEARCH,
        IMPROVING_THE_WORLD,
        SELF_DEVELOPMENT,
        BEAUTY_AND_ART,
        FAME_AND_INFLUENCE
    }

    public enum MainThingInPeople {
        SMARTNESS_AND_CREATIVITY,
        KINDNESS_AND_HONESTY,
        BEAUTY_AND_HEALTH,
        POWER_AND_WEALTH,
        COURAGE_AND_PERSEVERANCE,
        HUMOR
    }

    public enum Attitude {
        SHARPLY_NEGATIVE,
        NEGATIVE,
        COMPROMISE_SOLUTION,
        NEUTRAL,
        POSITIVE
    }

    @Id
    @Column(name = "id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "political_preference")
    private PoliticalPreference politicalPreference;

    @Enumerated(EnumType.STRING)
    @Column(name = "world_view")
    private WorldView worldView;

    @Enumerated(EnumType.STRING)
    @Column(name = "main_thing_in_life")
    private MainThingInLife mainThingInLife;

    @Enumerated(EnumType.STRING)
    @Column(name = "main_thing_in_people")
    private MainThingInPeople mainThingInPeople;

    @Enumerated(EnumType.STRING)
    @Column(name = "attitude_to_smoking")
    private Attitude attitudeToSmoking;

    @Enumerated(EnumType.STRING)
    @Column(name = "attitude_to_alcohol")
    private Attitude attitudeToAlcohol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "additional_profile_details_id")
    private AdditionalProfileDetails additionalProfileDetails;
}
