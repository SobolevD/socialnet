package usr.dmso.socialnet.model.profile.additional;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profile_interests")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileInterests {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "interests")
    private String interests;

    @Column(name = "favourite_music")
    private String favouriteMusic;

    @Column(name = "favourite_movies")
    private String favouriteMovies;

    @Column(name = "favourite_tv_shows")
    private String favouriteTvShows;

    @Column(name = "favourite_books")
    private String favouriteBooks;

    @Column(name = "favourite_games")
    private String favouriteGames;

    @Column(name = "favourite_quotes")
    private String favouriteQuotes;

    @Column(name = "about_me")
    private String aboutMe;

    @OneToOne
    @MapsId
    @JoinColumn(name = "additional_profile_details_id")
    private AdditionalProfileDetails additionalProfileDetails;
}
