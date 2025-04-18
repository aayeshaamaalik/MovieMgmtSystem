import java.time.LocalDate;

public class DateSpecification implements MovieSpecification {
    private LocalDate targetDate;

    public DateSpecification(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public boolean isSatisfied(Movie movie) {
        return movie.getShows().stream().anyMatch(
                show -> show.getStartTime().toLocalDate().equals(targetDate)
        );
    }
}
