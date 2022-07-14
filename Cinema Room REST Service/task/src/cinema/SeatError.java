package cinema;

public class SeatError implements SeatInterface {

    private String error;

    public SeatError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
