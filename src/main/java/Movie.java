import java.time.LocalDateTime;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String language;
    private String genre;
    private LocalDateTime releaseDate;
    private String description;
    private int durationMinutes;
    private List<Show> shows;

    public Movie(int id, String title, String language, String genre,
                 LocalDateTime releaseDate, String description, int durationMinutes, List<Show> shows) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.shows = shows;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Show> getShows() {
        return shows;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }
}
