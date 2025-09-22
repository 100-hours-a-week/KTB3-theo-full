import util.DB;
import service.CinemaService;

public class Main {
    public static void main(String[] args) {

        DB dummyDB = new DB();

        CinemaService cinemaService = new CinemaService(dummyDB);

        Runnable task1 = new ReservationTask(cinemaService); // 영화 예매 task1
        Runnable task2 = new ReservationTask(cinemaService); // 영화 예매 task2

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        try {
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
