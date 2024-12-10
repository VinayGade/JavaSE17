package beans.enums;

import beans.interfaces.Weather;
/*
public enum Season {

    WINTER, SPRING, SUMMER, FALL
}
 */

public enum Season implements Weather {

    WINTER, SPRING, SUMMER, FALL;

    @Override
    public int getAverageTemperature() {
        return 30;
    }
}
