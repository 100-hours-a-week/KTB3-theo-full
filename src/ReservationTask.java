import service.CinemaService;

public class ReservationTask implements Runnable {
    CinemaService cinemaService;

    public ReservationTask(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public void run() {
        cinemaService.start();
    }
}
