package domain.screen;

import java.util.ArrayList;

public class Screen {
    private String name;
    private ArrayList<ScreenTime> screenTimes;

    public Screen(String name) {
        this.name = name;
        screenTimes = new ArrayList<ScreenTime>();
    }

    public String getName() {
        return name;
    }
    public ArrayList<ScreenTime> getScreenTimes() {
        return screenTimes;
    }
}
