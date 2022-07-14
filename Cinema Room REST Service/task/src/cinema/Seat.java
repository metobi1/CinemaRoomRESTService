package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat implements SeatInterface {

    private int row;
    private int column;
    private int price;

    private boolean isTaken;

    public Seat(){}

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        setPrice();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    @JsonIgnore
    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public void setPrice() {
        // prices 10 and 8 are gives as requirements
        if (row <= 4) {
            price = 10;
        } else {
            price = 8;
        }
    }
}