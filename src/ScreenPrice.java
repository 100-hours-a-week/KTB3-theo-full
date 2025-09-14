enum ScreenPrice {
    IMAX(18000),
    TwoD(14000);

    private final int price;

    ScreenPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
