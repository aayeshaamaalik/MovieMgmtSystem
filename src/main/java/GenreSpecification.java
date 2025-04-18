public class GenreSpecification implements MovieSpecification {
    private String genre;

    public GenreSpecification(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean isSatisfied(Movie movie) {
        return movie.getGenre().equalsIgnoreCase(genre);
    }
}
