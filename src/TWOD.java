import java.time.LocalDate;

public class TWOD extends Movie {
    private ScreenType screenType = ScreenType.TWOD;
    private int price = ScreenPrice.TWOD.getPrice();

    public TWOD(String name, String genre, String director, int runningTime, double reviewRating, LocalDate releaseDate, int filmRating) {
        super(name, genre, director, runningTime, reviewRating, releaseDate, filmRating);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getMovieInfo() {
        return String.format("%s | %s", super.getMovieInfo(), screenType.getValue());
    }
}
