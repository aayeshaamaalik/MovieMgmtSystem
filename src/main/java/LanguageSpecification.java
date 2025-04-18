public class LanguageSpecification implements MovieSpecification {
    private String language;

    public LanguageSpecification(String language) {
        this.language = language;
    }

    @Override
    public boolean isSatisfied(Movie movie) {
        return movie.getLanguage().equalsIgnoreCase(language);
    }
}
