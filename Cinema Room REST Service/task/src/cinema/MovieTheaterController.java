package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieTheaterController {

    @GetMapping("/seats")
    public MovieTheater getMovieTheater() {
        MovieTheater movieTheater = new MovieTheater(9, 9);
        movieTheater.setAvailableSeats();
        return movieTheater;
    }
}

