package cinema;

import java.util.ArrayList;
import java.util.List;

public class MovieTheater {

    private int totalRows = 9;
    private int totalColumns = 9;
    private List<Seat> availableSeats =
            new ArrayList<>();

    public MovieTheater() {
        setAvailableSeats();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public void setAvailableSeats() {

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                availableSeats.add(new Seat(i, j));
            }
        }
    }

    public List<Seat> getAvailableSeats() {

        return availableSeats;
    }
}