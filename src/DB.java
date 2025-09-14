import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DB {
    private ArrayList<Movie> movieList;
    private ArrayList<Screen> screenList;

    public DB() {
        movieList = new ArrayList<>();
        screenList = new ArrayList<>();
        setDummyData();
    }

    public void setDummyData() {
        IMAX m1 = new IMAX("귀멸의 칼날-무한성편", "애니메이션", "하루오", 155, 9.18,
                LocalDate.of(2025, 8, 22), 15);
        IMAX m2 = new IMAX("F1 더 무비", "드라마", "조셉 코신스키", 155, 9.06,
                LocalDate.of(2025, 6, 25), 15);
        IMAX m3 = new IMAX("컨저링:마지막 의식", "공포", "마이클 차베즈", 135, 7.86,
                LocalDate.of(2025, 9, 3), 15);
        IMAX m4 = new IMAX("홈캠", "공포", "오세호", 93, 9.06,
                LocalDate.of(2025, 9, 10), 15);


        TWOD t1 = new TWOD("귀멸의 칼날-무한성편", "애니메이션", "하루오", 155, 9.18,
                LocalDate.of(2025, 8, 22), 15);
        TWOD t2 = new TWOD("F1 더 무비", "드라마", "조셉 코신스키", 155, 9.06,
                LocalDate.of(2025, 6, 25), 15);
        TWOD t3 = new TWOD("컨저링:마지막 의식", "공포", "마이클 차베즈", 135, 7.86,
                LocalDate.of(2025, 9, 3), 15);
        TWOD t4 = new TWOD("홈캠", "공포", "오세호", 93, 9.06,
                LocalDate.of(2025, 9, 10), 15);

        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);

        movieList.add(t1);
        movieList.add(t2);
        movieList.add(t3);
        movieList.add(t4);


        // IMAX 귀멸의 칼날, 2025-09-13 08:00
        ScreenTime st1 = new ScreenTime(m1, LocalDateTime.of(2025, 9, 13, 8, 0));
        // IMAX 귀멸의 칼날, 2025-09-13 13:00
        ScreenTime st2 = new ScreenTime(m1, LocalDateTime.of(2025, 9, 13, 13, 0));

        // IMAX F1 더 무비, 2025-09-13 09:00
        ScreenTime st3 = new ScreenTime(m2, LocalDateTime.of(2025, 9, 13, 9, 0));
        // IMAX F1 더 무비, 2025-09-13 14:00
        ScreenTime st4 = new ScreenTime(m2, LocalDateTime.of(2025, 9, 13, 14, 0));

        // IMAX 컨저링:마지막 의식, 2025-09-13 10:00
        ScreenTime st5 = new ScreenTime(m3, LocalDateTime.of(2025, 9, 13, 10, 0));
        // IMAX 컨저링:마지막 의식, 2025-09-13 15:00
        ScreenTime st6 = new ScreenTime(m3, LocalDateTime.of(2025, 9, 13, 15, 0));

        // IMAX 홈캠:마지막 의식, 2025-09-13 11:00
        ScreenTime st7 = new ScreenTime(m4, LocalDateTime.of(2025, 9, 13, 11, 0));
        // IMAX 컨저링:마지막 의식, 2025-09-13 16:00
        ScreenTime st8 = new ScreenTime(m4, LocalDateTime.of(2025, 9, 13, 16, 0));

        /////////

        // 2D 귀멸의 칼날, 2025-09-13 08:00
        ScreenTime st9 = new ScreenTime(t1, LocalDateTime.of(2025, 9, 13, 8, 0));
        // 2D 귀멸의 칼날, 2025-09-13 13:00
        ScreenTime st10 = new ScreenTime(t1, LocalDateTime.of(2025, 9, 13, 13, 0));

        // 2D F1 더 무비, 2025-09-13 09:00
        ScreenTime st11 = new ScreenTime(t2, LocalDateTime.of(2025, 9, 13, 9, 0));
        // 2D F1 더 무비, 2025-09-13 14:00
        ScreenTime st12 = new ScreenTime(t2, LocalDateTime.of(2025, 9, 13, 14, 0));

        // 2D 컨저링:마지막 의식, 2025-09-13 10:00
        ScreenTime st13 = new ScreenTime(t3, LocalDateTime.of(2025, 9, 13, 10, 0));
        // 2D 컨저링:마지막 의식, 2025-09-13 15:00
        ScreenTime st14 = new ScreenTime(t3, LocalDateTime.of(2025, 9, 13, 15, 0));

        // 2D 홈캠:마지막 의식, 2025-09-13 11:00
        ScreenTime st15 = new ScreenTime(t4, LocalDateTime.of(2025, 9, 13, 11, 0));
        // 2D 컨저링:마지막 의식, 2025-09-13 16:00
        ScreenTime st16 = new ScreenTime(t4, LocalDateTime.of(2025, 9, 13, 16, 0));

        Screen s1 = new Screen("1관");
        s1.getScreenTimes().add(st1);
        s1.getScreenTimes().add(st2);
        s1.getScreenTimes().add(st3);
        s1.getScreenTimes().add(st4);
        s1.getScreenTimes().add(st5);
        s1.getScreenTimes().add(st6);
        s1.getScreenTimes().add(st7);
        s1.getScreenTimes().add(st8);

        Screen s2 = new Screen("2관");
        s2.getScreenTimes().add(st9);
        s2.getScreenTimes().add(st10);
        s2.getScreenTimes().add(st11);
        s2.getScreenTimes().add(st12);
        s2.getScreenTimes().add(st13);
        s2.getScreenTimes().add(st14);
        s2.getScreenTimes().add(st15);
        s2.getScreenTimes().add(st16);

        screenList.add(s1);
        screenList.add(s2);

    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Screen> getScreenList() {
        return screenList;
    }

    ;
}
