
# Movie Ticket Booking System

This project is an implementation of a Movie Ticket Booking System, modeled after real-world platforms like BookMyShow and designed using Object-Oriented Design (OOD) principles. It enables users to browse available movies, view showtimes and seat availability, and book or cancel tickets.

**Design Reference:**  
The system is inspired by the [Movie Ticket Booking System Design](https://github.com/ycwkatie/OOD-Object-Oriented-Design/blob/main/ood/movie_ticket.md) from the OOD-Object-Oriented-Design repository by ycwkatie.

---

## Key Components and Interacting Objects

The system is structured around domain-driven components and supports extensibility via the Specification Pattern.

- **MovieBookingSystem**: Core orchestrator for managing cities, cinemas, movies, shows, bookings, and payments.
- **City**: Represents a city containing multiple cinemas.
- **Cinema**: A movie theater location with one or more cinema halls.
- **CinemaHall**: A specific screening room within a cinema with a defined seat layout.
- **Movie**: Represents a film with details such as title, language, genre, release date, and duration.
- **Show**: A scheduled screening of a movie at a specific time and cinema hall.
- **Seat**: Represents an individual seat that can be reserved.
- **Booking**: Captures a successful seat reservation for a show.
- **Payment**: Represents a ticket payment with status and transaction details.
- **Specification Pattern**: Enables flexible, composable filters for searching movies.

---

## User Action Flow

The Movie Booking System supports the end-to-end journey of searching and booking tickets. All operations are exposed via methods in the `MovieBookingSystem` class:

1. `addCity(City city)` and `addMovie(Movie movie)`  
   Initializes the system by registering cities and movies.

2. `searchMovies(MovieSpecification spec)`  
   Filters movies using pluggable search criteria like city, genre, language, or date.

3. `getShowsForMovie(String movieTitle, String cityName)`  
   Retrieves all scheduled shows for a given movie in a specific city.

4. `getAvailableSeats(Show show)`  
   Returns all available (non-reserved) seats for a particular show.

5. `bookSeats(Show show, List<Integer> seatNumbers, double amount)`  
   Books selected seats for a show and processes a payment.  
   Returns a `Booking` object with ticket and seat details.

6. `cancelBooking(String bookingId)`  
   Cancels a confirmed booking and frees up the reserved seats.

---

## Getting Started

To set up and run the project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/movie-booking-system.git
   ```

2. Navigate into the project folder:
   ```bash
   cd movie-booking-system
   ```

3. Open in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse)

4. Build and run the project  
   Ensure your environment supports **Java 8+**.

---

## Project Structure

| Component                     | Responsibility                                                   |
|------------------------------|-------------------------------------------------------------------|
| `MovieBookingSystem`         | Central system managing entities and user actions                |
| `City`, `Cinema`, `CinemaHall` | Organize theaters and screening infrastructure                 |
| `Movie`, `Show`              | Define movies and their scheduled screen times                   |
| `Seat`, `Booking`, `Payment`| Handle reservations, payments, and availability                  |
| `MovieSpecification`         | Abstract interface for filtering movies                         |
| `GenreSpecification`, `CitySpecification`, `DateSpecification`, etc. | Reusable search filters  |


