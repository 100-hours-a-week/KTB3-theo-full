package domain.screen;

import domain.movie.Movie;
import util.Cinema_Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenTime {
    private Movie movie;
    private LocalDateTime time;
    private volatile boolean[][] seats;

    public ScreenTime(Movie movie, LocalDateTime time) {
        this.movie = movie;
        this.time = time;
        this.seats = new boolean[ScreenSize.TWOD.getRow()][ScreenSize.TWOD.getCol()];
    }

    public ScreenTime(Movie movie, LocalDateTime time, ScreenSize screenSize) {
        this.movie = movie;
        this.time = time;
        this.seats = new boolean[screenSize.getRow()][screenSize.getCol()];
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time.format(DateTimeFormatter.ofPattern("MM월 dd일 HH:mm"));
    }

    public synchronized boolean[][] getSeats() {
        return seats;
    }

    public synchronized String selectSeat(String selectSeat) {
        char choose_row = selectSeat.charAt(0);
        char choose_col = selectSeat.charAt(1);

        char seatMaxRow = (char) ('A' + (seats.length - 1));
        char seatMaxCol = (char) ('1' + (seats[0].length - 1));

        boolean isSeatInRange = isSeatInRange(choose_row, choose_col);
        boolean isSelectedSeat = isSelectedSeat(selectSeat);

        while (!isSeatInRange || isSelectedSeat) {
            System.out.print("ㅁ 좌석을 다시 선택해주세요 (A-" + seatMaxRow + ")(1-" + seatMaxCol + ") ex) A1 : ");
            selectSeat = Cinema_Util.getUserSeatInput();
            choose_row = selectSeat.charAt(0);
            choose_col = selectSeat.charAt(1);
            isSeatInRange = isSeatInRange(choose_row, choose_col);
            isSelectedSeat = isSelectedSeat(selectSeat);
        }

        this.seats[choose_row - 'A'][choose_col - '1'] = true;
        return selectSeat;
    }

    private boolean isSelectedSeat(String selectSeat) {
        try {
            char choose_row = selectSeat.charAt(0);
            char choose_col = selectSeat.charAt(1);
            return this.seats[choose_row - 'A'][choose_col - '1'];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean isSeatInRange(char row, char col) {
        char seatMaxRow = (char) ('A' + (seats.length - 1));
        char seatMaxCol = (char) ('1' + (seats[0].length - 1));

        return (row >= 'A' && row <= seatMaxRow) && (col >= '1' && col <= seatMaxCol);
    }
}
