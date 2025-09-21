package domain.movie;

import java.time.LocalDate;

public class IMAX extends Movie{
    private ScreenType screenType = ScreenType.IMAX;
    private int price = MoviePrice.IMAX.getPrice();

    public IMAX(String name, String genre, String director, int runningTime, double reviewRating, LocalDate releaseDate, int filmRating) {
        super(name, genre, director,runningTime,reviewRating,releaseDate, filmRating);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getScreenType() { return screenType.getScreenType();}

    @Override
    public String getMovieInfo() {
        return String.format("%s | %s", super.getMovieInfo(), screenType.getScreenType());
    }
}
