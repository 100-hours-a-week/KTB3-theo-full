package domain.movie;

public class Content {
    private String name;
    private String genre;

    public Content(String name, String gnere) {
        this.name = name;
        this.genre = gnere;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

}
