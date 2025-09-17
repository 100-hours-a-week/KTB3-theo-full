public enum ScreenType {
    IMAX("IMAX"), TWOD("TWOD");

    private String screenType;
    ScreenType(String screenType) {
        this.screenType = screenType;
    }

    // test
    public String getScreenType() {
        return screenType;
    }
}
