package service;

public enum CinemaServiceConfig {
    YES(1), No(2);

    private final int config;

    CinemaServiceConfig(int config) {
        this.config = config;
    }

    public int getConfig() {
        return this.config;
    }
}
