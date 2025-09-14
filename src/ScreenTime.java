import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenTime {
    private Movie movie;
    private LocalDateTime time;
    private int[][] seats;

    public ScreenTime(Movie movie, LocalDateTime time) {
        this.movie = movie;
        this.time = time;
        this.seats = new int[3][3];
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time.format(DateTimeFormatter.ofPattern("MM월 dd일 HH:mm"));
    }

    public int[][] getSeats() {
        return seats;
    }
}
