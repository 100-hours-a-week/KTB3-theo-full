package domain.movie;

public enum MoviePrice {
    IMAX(18000),
    TWOD(14000);

    private final int price;

    MoviePrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
