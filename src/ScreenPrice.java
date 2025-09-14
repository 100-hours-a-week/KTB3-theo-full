enum ScreenPrice {
    IMAX(18000),
    TWOD(14000);

    private final int price;

    ScreenPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
