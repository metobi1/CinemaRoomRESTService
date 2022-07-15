package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class MovieTheaterController {

    MovieTheater movieTheater = new MovieTheater();
    //Returns bought = new Returns(movieTheater);

    @GetMapping("/seats")
    public MovieTheater getMovieTheaterSeats() {
        return movieTheater;
    }

    @PostMapping("/purchase")
    public Purchase buyMovieTheaterTicket(@RequestBody Seat seatRequest) {

        for (Seat seat : movieTheater.getAvailableSeats()) {
            if (seat.getRow() == seatRequest.getRow() &&
                    seat.getColumn() == seatRequest.getColumn()) {

                if (seat.isTaken()) {
                    throw new SeatException("The ticket has been already purchased!");
                } else {
                    seat.setTaken(true);
                    Purchase purchase = new Purchase(seat);
                    movieTheater.storeTicket(purchase.getToken(), seat);
                    return purchase;
                }
            }
        }
        throw new SeatException("The number of a row or a column is out of bounds!");
    }

    @PostMapping("/return")
    public ReturnedTicket returnedTicket(@RequestBody Purchase token) {

        for (UUID storedToken : movieTheater.getTickets().keySet()) {

            if (storedToken.equals(token.getToken())) {
                Seat seat = movieTheater.getTickets().get(token.getToken());
                ReturnedTicket returnedTicket = new ReturnedTicket(seat);
                seat.setTaken(false);
                movieTheater.getTickets().remove(storedToken);
                return returnedTicket;
            }
        }
        throw new SeatException("Wrong token!");
    }
}