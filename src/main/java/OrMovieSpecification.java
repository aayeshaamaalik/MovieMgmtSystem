public class OrMovieSpecification implements MovieSpecification {
    private MovieSpecification one;
    private MovieSpecification other;

    public OrMovieSpecification(MovieSpecification one, MovieSpecification other) {
        this.one = one;
        this.other = other;
    }

    @Override
    public boolean isSatisfied(Movie movie) {
        return one.isSatisfied(movie) || other.isSatisfied(movie);
    }
}
