package cinema;

public class TicketSalesReport {

    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;

    public int getCurrentIncome() {
        return currentIncome;
    }

    TicketSalesReport(MovieTheater movieTheater) {
        setCurrentIncome(movieTheater);
        setNumberOfAvailableSeats(movieTheater);
        setNumberOfPurchasedTickets(movieTheater);
    }

    public void setCurrentIncome(MovieTheater movieTheater) {
        for (Seat seat : movieTheater.getAvailableSeats()) {
            if (seat.isTaken()) {
                currentIncome = currentIncome + seat.getPrice();
            }
        }
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(MovieTheater movieTheater) {
        for (Seat seat : movieTheater.getAvailableSeats()) {
            if (!seat.isTaken()) numberOfAvailableSeats++;
        }
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(MovieTheater movieTheater) {
        for (Seat seat : movieTheater.getAvailableSeats()) {
            if (seat.isTaken()) numberOfPurchasedTickets++;
        }
    }
}
