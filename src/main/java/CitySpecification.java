import java.util.List;

public class CitySpecification implements MovieSpecification {
    private String cityName;
    private List<City> cities;

    public CitySpecification(String cityName, List<City> cities) {
        this.cityName = cityName;
        this.cities = cities;
    }

    @Override
    public boolean isSatisfied(Movie movie) {
        for (Show show : movie.getShows()) {
            for (City city : cities) {
                if (city.getName().equalsIgnoreCase(cityName)) {
                    for (Cinema cinema : city.getCinemas()) {
                        for (CinemaHall hall : cinema.getCinemaHalls()) {
                            if (Integer.toString(hall.getId()).equals(show.getCinemaHallId())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
