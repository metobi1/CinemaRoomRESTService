package cinema;

import java.util.ArrayList;
import java.util.List;

public class MovieTheater {

    private int totalRows;
    private int totalColumns;
    private List<Seats> availableSeats =
            new ArrayList<>();

    public MovieTheater(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
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
                availableSeats.add(new Seats(i, j));
            }
        }
    }

    public List<Seats> getAvailableSeats() {

        return availableSeats;
    }
}