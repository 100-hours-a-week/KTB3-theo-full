package domain.movie;

import java.time.LocalDate;


public abstract class Movie extends Content{
    private String director;
    private int runningTime;
    private double reviewRating;
    private LocalDate releaseDate;
    private double filmRating;

    public Movie(String name, String genre, String director, int runningTime, double reviewRating,
                 LocalDate releaseDate, int filmRating) {
        super(name, genre);
        this.director = director;
        this.runningTime = runningTime;
        this.reviewRating = reviewRating;
        this.releaseDate = releaseDate;
        this.filmRating = filmRating;
    }

    public String getMovieInfo() {
        return String.format("%s | %s | %s | %d분",
                super.getName(), super.getGenre(), director, runningTime);
    }

    public abstract int getPrice();
    public abstract String getScreenType();
}
