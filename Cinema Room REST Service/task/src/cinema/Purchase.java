package cinema;

import java.util.UUID;

public class Purchase {

    private UUID token = UUID.randomUUID();
    private Seat ticket;

    Purchase(){}
    Purchase(Seat ticket) {
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }
}
