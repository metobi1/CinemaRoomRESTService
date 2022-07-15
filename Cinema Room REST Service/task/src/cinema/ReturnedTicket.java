package cinema;

public class ReturnedTicket {

    private Seat returnedTicket;

    public ReturnedTicket(Seat returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public Seat getReturnedTicket() {
        return returnedTicket;
    }
}
