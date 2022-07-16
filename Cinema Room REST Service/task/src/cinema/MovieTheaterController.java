package cinema;

import org.springframework.web.bind.annotation.*;

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
                    throw new CinemaException("The ticket has been already purchased!");
                } else {
                    seat.setTaken(true);
                    Purchase purchase = new Purchase(seat);
                    movieTheater.storeTicket(purchase.getToken(), seat);
                    return purchase;
                }
            }
        }
        throw new CinemaException("The number of a row or a column is out of bounds!");
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
        throw new CinemaException("Wrong token!");
    }

    @PostMapping("/stats")
    public TicketSalesReport ticketSalesReport(@RequestParam(required = false) String password) {
        if ("super_secret".equals(password)) {
            return new TicketSalesReport(movieTheater);
        }
        throw new SecurityException("The password is wrong!");
    }
}