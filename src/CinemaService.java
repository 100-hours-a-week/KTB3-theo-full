import java.util.ArrayList;

public class CinemaService<T> {
    static DB dummyDB = new DB();

    public void start() {
        try {
            printStartMenu();
            selectStartMenu(Cinema_Util.getUserIntegerInput());

            Movie[] movies = getMovieList();
            displayMovieList(movies);

            Movie selectMovie = selectMovie(movies, Cinema_Util.getUserIntegerInput());
            ArrayList<ScreenTime> screenTimes = getScreenTimeList(selectMovie);
            displayScreenTImeList(screenTimes);

            ScreenTime selectScreenTime = selectScreenTime(screenTimes, Cinema_Util.getUserIntegerInput());

            boolean[][] seats = getSeatList(selectScreenTime);
            displaySeatList(seats);
            String selectSeat = Cinema_Util.getUserStringInput();

            selectSeat(seats, selectSeat);

            displayTicketInfo(selectMovie, selectSeat);

            displayRequestPayment(selectMovie);
            boolean isPaymentSuccess = requestPayment(selectMovie, Cinema_Util.getUserIntegerInput());
            displayPaymentResult(isPaymentSuccess);

        } catch (Exception e) {
            UI.ERROR_MENU.linePrint();
            start();
        } finally {
            Cinema_Util.s.close();
        }
    }

    private boolean printStartMenu() {
        try {
            UI.START_MENU.linePrint(); // 초기 화면 display
            UI.SELECT_START.print();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean selectStartMenu(int num) {
        return num == 1;
    }

    // DB -> 영화리스트 가져오기
    private Movie[] getMovieList() {
        return dummyDB.getMovieList().toArray(new Movie[0]);
    }

    // 영화리스트 출력
    private void displayMovieList(Movie[] movies) {
        UI.DIVIDING_LINE.linePrint();
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            System.out.println((i + 1) + ". " + movie.getMovieInfo());
        }

        UI.DIVIDING_LINE.linePrint();
        UI.SELECTING_MOVIE.print();
    }

    // 영화리스트 중에서 선택
    private Movie selectMovie(Movie[] movies, int selectMovieNum) {
        Movie selectMovie = movies[selectMovieNum - 1];
        return selectMovie;
    }

    // DB -> 상영관 리스트 가져오기
    private Screen[] getScreenList() {
        return dummyDB.getScreenList().toArray(new Screen[0]);
    }

    // 선택한 영화에 대한 상영시간표 가져오기
    private ArrayList<ScreenTime> getScreenTimeList(Movie selectMovie) {
        Screen[] screens = getScreenList();
        ArrayList<ScreenTime> screenTimes = new ArrayList<ScreenTime>();
        for (int i = 0; i < screens.length; i++) {
            Screen screen = screens[i];
            ScreenTime[] allScreenTimes = screen.getScreenTimes().toArray(new ScreenTime[0]);

            for (int j = 0; j < allScreenTimes.length; j++) {
                ScreenTime screenTime = allScreenTimes[j];
                String movieName = screenTime.getMovie().getName();
                if (selectMovie.getName().equals(movieName)) {
                    screenTimes.add(screenTime);
                }
            }
        }
        return screenTimes;
    }

    // 상영시간표 출력
    private void displayScreenTImeList(ArrayList<ScreenTime> screenTimes) {
        UI.DIVIDING_LINE.linePrint();
        for (int i = 0; i < screenTimes.size(); i++) {
            ScreenTime screenTime = screenTimes.get(i);
            String movieName = screenTime.getMovie().getName();
            String screenType = screenTime.getMovie().getScreenType();
            String time = screenTime.getTime();
            System.out.println((i + 1) + ". " + movieName + "(" + screenType + ")" + "\t".repeat(2) + time + " ");
        }
        UI.DIVIDING_LINE.linePrint();
        UI.SELECTING_SCREENTIME.print();
    }

    // 상영시간표 선택
    private ScreenTime selectScreenTime(ArrayList<ScreenTime> screenTimes, int selectScreenTimeNum) {
        return screenTimes.get(selectScreenTimeNum - 1);
    }

    // 좌석표 출력
    private void displaySeatList(boolean[][] seats) {
        UI.DIVIDING_LINE.linePrint();
        UI.SCREEN.linePrint();

        System.out.printf("\t".repeat(6) + "%2s", " ");
        for (int guide_row = 1; guide_row <= seats[0].length; guide_row++) {
            System.out.print(guide_row + " ");
        }

        System.out.println();
        char guideCol = 'A';
        for (int i = 0; i < seats.length; i++) {
            boolean[] seats_col = seats[i];
            System.out.print("\t".repeat(6) + guideCol + " ");
            guideCol++;
            for (int j = 0; j < seats_col.length; j++) {
                boolean isReserved = seats_col[j];
                String seatStatus = isReserved ? "◼︎" : "◻︎";
                System.out.print(seatStatus + " ");
            }
            System.out.println();
        }
        UI.DIVIDING_LINE.linePrint();
        UI.SELECTING_SEAT.print();
    }

    // 선택한 상영 시간표에 대한 좌석정보 가져오기
    private boolean[][] getSeatList(ScreenTime selectScreenTime) {
        return selectScreenTime.getSeats();
    }

    // 좌석 선택
    private boolean[][] selectSeat(boolean[][] seats, String selectSeat) {
        char choose_row = selectSeat.charAt(0);
        char choose_col = selectSeat.charAt(1);
        seats[choose_row - 'A'][choose_col - '1'] = false;
        return seats;
    }

    // 최종 영화정보(티켓) 출력
    private void displayTicketInfo(Movie selectMovie, String selectSeat) {
        UI.DIVIDING_LINE.linePrint();
        System.out.println("ㅁ 선택하신 관람은 ");
        System.out.println("ㅁ " + selectMovie.getMovieInfo() + "이며");
        System.out.println("ㅁ " + selectSeat + "좌석입니다.");
        System.out.println("ㅁ 결제하실 금액은 " + selectMovie.getPrice() + "원 입니다.");


        UI.DIVIDING_LINE.linePrint();
    }

    // 결제요청화면 출력
    private void displayRequestPayment(Movie selectMovie) {
        UI.PAYMENT_START.linePrint();
        System.out.println("ㅁ " + selectMovie.getPrice() + "원입니다.");
        UI.PAYMENT_REQUEST.linePrint();
        UI.DIVIDING_LINE.linePrint();
        UI.REQUEST_PAYMENT_AMOUNT.print();
    }

    // 결제 요청
    private boolean requestPayment(Movie selectMovie, int price) {
        int moviePrice = selectMovie.getPrice();

        while (price != moviePrice) {
            UI.PAYMENT_INPUT_ERROR.linePrint();
            UI.REQUEST_PAYMENT_AMOUNT.print();
            price = Cinema_Util.getUserIntegerInput();

        }

        return true;
    }

    // 결제결과화면 출력
    private void displayPaymentResult(boolean isPaymentSuccess) {
        if (isPaymentSuccess) {
            UI.PAYMENT_SUCCESS.linePrint();
        } else {
            UI.PAYMENT_FAIL.linePrint();
        }
    }
}
