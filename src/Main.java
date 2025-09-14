import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static DB dummyDB = new DB();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println(UI.START_MENU.display()); // 초기 화면 display
            System.out.print(UI.SELECT_START.display());

            System.out.println("test");
            if (s.nextInt() == 1) {
                Movie[] movies = displayMovieList();
                int selectMovieNum = s.nextInt(); // 영화 선택
                Movie selectMovie = selectMovie(movies, selectMovieNum);

                if (selectMovieNum <= movies.length) {

                    ArrayList<ScreenTime> screenTimes = displayScreenTimeList(selectMovie);
                    int selectScreenTimeNum = s.nextInt(); // 상영시간 선택
                    ScreenTime selectScreenTime = selectScreenTime(screenTimes, selectScreenTimeNum);

                    if (selectScreenTimeNum <= screenTimes.size()) {
                        int[][] seats = displaySeatList(selectScreenTime);
                        String selectSeat = s.next(); // 좌석선택
                        selectSeat(seats, selectSeat);

                        if (selectSeat != null) {
                            displayTicketInfo(selectScreenTime, selectMovie, selectSeat);
                            displayPayment((selectMovie));
                        }
                    }
                }

            } else {
                System.out.println(UI.END_MENU.display());
            }
        } catch (Exception e) {
            System.out.println(UI.ERROR_MENU.display());
            e.printStackTrace();
        }
    }

    // 영화리스트 출력
    public static Movie[] displayMovieList() {
        System.out.println(UI.DIVIDING_LINE.display());
        Movie[] movies = dummyDB.getMovieList().toArray(new Movie[0]);
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            System.out.println((i + 1) + ". " + movie.getMovieInfo());
        }
        System.out.println(UI.DIVIDING_LINE.display());
        System.out.print(UI.SELECTING_MOVIE.display());

        return movies;
    }

    // 영화리스트 중에서 선택
    public static Movie selectMovie(Movie[] movies, int selectMovieNum) {
        Movie selectMovie = movies[selectMovieNum - 1];
        return selectMovie;
    }

    // 상영시간표 출력
    public static ArrayList<ScreenTime> displayScreenTimeList(Movie selectMovie) {
        System.out.println(UI.DIVIDING_LINE.display());
        Screen[] screens = dummyDB.getScreenList().toArray(new Screen[0]);

        int selectScreenTimeNum = 1;
        ArrayList<ScreenTime> screenTimes = new ArrayList<ScreenTime>();
        for (int i = 0; i < screens.length; i++) {
            Screen screen = screens[i];
            ScreenTime[] allScreenTimes = screen.getScreenTimes().toArray(new ScreenTime[0]);

            for (int j = 0; j < allScreenTimes.length; j++) {
                ScreenTime screenTime = allScreenTimes[j];
                String movieName = screenTime.getMovie().getName();
                String screenType = screenTime.getMovie().getClass().getName();
                if (selectMovie.getName().equals(movieName)) {
                    String time = screenTime.getTime();
                    System.out.println(selectScreenTimeNum + ". " + movieName + "(" + screenType + ")" + "\t".repeat(2) + time + " ");
                    screenTimes.add(screenTime);
                    selectScreenTimeNum++;
                }
            }
        }

        System.out.println(UI.DIVIDING_LINE.display());
        System.out.print(UI.SELECTING_SCREENTIME.display());
        return screenTimes;
    }

    // 상영시간표 선택
    public static ScreenTime selectScreenTime(ArrayList<ScreenTime> screenTimes, int selectScreenTimeNum) {
        return screenTimes.get(selectScreenTimeNum - 1);
    }

    // 좌석표 출력
    public static int[][] displaySeatList(ScreenTime selectScreenTime) {
        System.out.println(UI.DIVIDING_LINE.display());
        System.out.println(UI.SCREEN.display());

        System.out.printf("\t".repeat(6) + "%2s", " ");
        int[][] seats = selectScreenTime.getSeats();
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print((i + 1) + " ");
        }

        System.out.println();
        char initCol = 'A';
        for (int i = 0; i < seats.length; i++) {
            int[] seat_col = seats[i];
            System.out.print("\t".repeat(6) + initCol + " ");
            initCol++;
            for (int j = 0; j < seat_col.length; j++) {
                int seat_row = seat_col[j];
                System.out.print(seat_row + " ");
            }
            System.out.println();
        }
        System.out.println(UI.DIVIDING_LINE.display());
        System.out.print(UI.SELECTING_SEAT.display());
        return seats;
    }

    // 좌석 선택
    public static int[][] selectSeat(int[][] seats, String selectSeat) {
        char row = selectSeat.charAt(0);
        char col = selectSeat.charAt(1);
        seats[row - 'A'][col - '1'] = 1;
        return seats;
    }

    // 최종 영화정보(티켓) 출력
    public static void displayTicketInfo(ScreenTime selectScreenTime, Movie selectMovie, String selectSeat) {
        System.out.println(UI.DIVIDING_LINE.display());
        String screenType = selectScreenTime.getMovie().getClass().getName();
        System.out.println("ㅁ 선택하신 관람은 ");

        if (screenType.equals("IMAX")) {
            selectMovie = (IMAX) selectMovie;
            System.out.println("ㅁ " + selectMovie.getMovieInfo() + "이며");
            System.out.println("ㅁ " + selectSeat + "좌석입니다.");
            System.out.println("ㅁ 결제하실 금액은 " + ((IMAX) selectMovie).getPrice() + "원 입니다.");
        } else if (screenType.equals("TWOD")) {
            selectMovie = (TWOD) selectMovie;
            System.out.println(selectMovie.getMovieInfo());
            System.out.println("ㅁ 결제하실 금액은 " + ((TWOD) selectMovie).getPrice() + "원 입니다.");
        }

        System.out.println(UI.DIVIDING_LINE.display());
    }

    // 결제화면 출력
    public static void displayPayment(Movie selectMovie) {
        int moviePrice = selectMovie.getPrice();
        System.out.println(UI.PAYMENT_START.display());
        System.out.println("ㅁ " + moviePrice + "원입니다.");
        System.out.println(UI.PAYMENT_REQUEST.display());
        System.out.println(UI.DIVIDING_LINE.display());
        System.out.print(UI.PAYMENT_INPUT.display());
        int price = s.nextInt();

        while(price != moviePrice) {
            System.out.println(UI.PAYMENT_INPUT_ERROR.display());
            System.out.print(UI.PAYMENT_INPUT.display());
            price = s.nextInt();
        }
        System.out.println(UI.DIVIDING_LINE.display());
        System.out.println(UI.PAYMENT_SUCCESS.display());
    }
}
