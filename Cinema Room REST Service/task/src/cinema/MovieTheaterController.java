package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieTheaterController {

    MovieTheater movieTheater = new MovieTheater();

    @GetMapping("/seats")
    public MovieTheater getMovieTheaterSeats() {
        return movieTheater;
    }

    @PostMapping("/purchase")
    public Seat buyMovieTheaterSeat(@RequestBody Seat seatRequest) {

        for (Seat seat : movieTheater.getAvailableSeats()) {
            if (seat.getRow() == seatRequest.getRow() &&
                    seat.getColumn() == seatRequest.getColumn()) {

                if (seat.isTaken()) {
                    throw new SeatException("The ticket has been already purchased!");
                } else {
                    seat.setTaken(true);
                    return seat;
                }
            }
        }
        throw new SeatException("The number of a row or a column is out of bounds!");
    }
}