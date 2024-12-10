package switchcase;

import beans.enums.Season;
import beans.enums.WeekDay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class WeekDemo {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalDate tomorrow = localDate.plusDays(1);
        var yesterdate = localDate.minusDays(1);
        var previousMonthSameDate = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        var Date3Monthsb4 = LocalDate.now().minus(3, ChronoUnit.MONTHS);
        var Date3MonthsAfter = LocalDate.now().plus(3, ChronoUnit.MONTHS);

        DayOfWeek today = localDate.getDayOfWeek();
        DayOfWeek yesterday = yesterdate.getDayOfWeek();
        var dayOfTomorrow = tomorrow.getDayOfWeek();
        var previousMonthSameWeekDay = previousMonthSameDate.getDayOfWeek();
        var someDate = localDate.plusDays(3);
        var someDay = someDate.getDayOfWeek();

        System.out.println("\nToday is "+today.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        System.out.println("yesterday was "+yesterday.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        System.out.println("Tomorrow will be "+dayOfTomorrow.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));

        System.out.println("\npreviousMonthSameDate was "+previousMonthSameDate.format(DateTimeFormatter.BASIC_ISO_DATE));

        System.out.println("\n Todays date :"+localDate.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", weekay = "+
                today.getDisplayName(TextStyle.FULL, Locale.ENGLISH) +
                ", Status : "+getStatusOld(WeekDay.valueOf(        //getStatusOld
                        today.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase())));

        System.out.println("\n yesterday was:"+yesterdate.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", weekay = "+
                yesterday.getDisplayName(TextStyle.FULL, Locale.ENGLISH) +
                ", Status : "+getStatusSwitchExpression(WeekDay.valueOf(          //getStatusOld  getStatus14  getStatusNew
                yesterday.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase())));

        System.out.println("\n Tomorrow will be :"+tomorrow.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", weekay = "+
                dayOfTomorrow.getDisplayName(TextStyle.FULL, Locale.ENGLISH) +
                ", Status : "+getStatus14(WeekDay.valueOf(          //getStatusOld  getStatus14  getStatusNew
                dayOfTomorrow.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase())));

        System.out.println("\n previousMonthSameWeekDay was :"+previousMonthSameDate.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", weekay = "+
                previousMonthSameWeekDay.getDisplayName(TextStyle.FULL, Locale.ENGLISH) +
                ", Status : "+getStatusNew(WeekDay.valueOf(          // getStatusNew getStatusNewOptimized
                previousMonthSameWeekDay.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase())));

        System.out.println("\n some random day :"+someDate.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", weekay = "+
                someDay.getDisplayName(TextStyle.FULL, Locale.ENGLISH) +
                ", Status : "+getStatusNewOptimized(WeekDay.valueOf(          // getStatusNew getStatusNewOptimized
                someDay.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase())));

        System.out.println("\n ***************** Weather ********************");

        Month month = localDate.getMonth();

        System.out.println("\n Today");
        System.out.println("Today is "+localDate.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", weekday = "+
                today.getDisplayName(TextStyle.FULL, Locale.ENGLISH)+", month = "+month);

        Season season = getSeason(month);
        System.out.println("season of "+month.name()+" is "+season.name());
        System.out.println("weather of "+season.name()+" is "+getWeather(season));

        Month monthb4 = Date3Monthsb4.getMonth();

        System.out.println("\n 3 Months b4");
        System.out.println("Date was "+Date3Monthsb4.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", month = "+monthb4);

        Season seasonb4 = getSeason(monthb4);
        System.out.println("season of "+monthb4.name()+" was "+seasonb4.name());
        System.out.println("weather of "+seasonb4.name()+" was "+getWeather(seasonb4));

        Month monthAfter = Date3MonthsAfter.getMonth();

        System.out.println("\n 3 Months after");
        System.out.println("Date will be "+Date3MonthsAfter.format(DateTimeFormatter.BASIC_ISO_DATE)+ ", month = "+monthAfter);

        Season seasonAfter = getSeason(monthAfter);
        System.out.println("season of "+monthAfter.name()+" will be "+seasonAfter.name());
        System.out.println("weather of "+seasonAfter.name()+" will be  "+getWeather(seasonAfter));

    }

    //prior to Java 14
    public static String getStatusOld(WeekDay day){
        String result ="";
        switch (day){
            case SUNDAY:
            case SATURDAY:
                result = "Enjoy Weekend!!";
                break;

            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                result = "Its Working Day. Get Ready for work ...";
                break;

            default:
                result = "Invalid day. Please enter valid weekday ...";
                break;
        }
        return result;
    }

    public static String getStatus14(WeekDay day){
        var result ="";
        switch (day){


            //way 1

            case SUNDAY, SATURDAY -> {
                result = "Enjoy Weekend!!";
            }

            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                result = "Its Working Day. Get Ready for work ...";
            }

            default -> {
                result = "Invalid day. Please enter valid weekday ...";
            }

            /*
            //way 2
            case SUNDAY, SATURDAY:
                result = "Enjoy Weekend!!";
                break;

            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                result = "Its Working Day. Get Ready for work ...";
                break;

            default:
                result = "Invalid day. Please enter valid weekday ...";
                break;

             */
        }
        return result;
    }

    //Switch Expression : Java 12
    public static String getStatusSwitchExpression(WeekDay day){
        var result = switch(day) {
            case SUNDAY, SATURDAY -> "Enjoy Weekend!!";
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Its Working Day. Get Ready for work ...";
            //default -> "Invalid day. Please enter valid weekday ...";
        };
        return result;
    }

    // Java 17 : Most optimized approach  : Scala's Pattern Matching 
    public static String getStatusNew(WeekDay day){
        return switch(day) {
            case SUNDAY, SATURDAY -> "Enjoy Weekend!!";
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Its Working Day. Get Ready for work ...";
            //default -> "Invalid day. Please enter valid weekday ...";
        };
    }

    public static String getStatusNewOptimized(WeekDay day){
        return switch(day) {
            case SUNDAY, SATURDAY -> "Enjoy Weekend!!";
            default -> "Its Working Day. Get Ready for work ...";
        };
    }

    //concise code
    public static Season getSeason(Month month){
        return switch(month){
            case MARCH, APRIL, MAY -> Season.SUMMER;
            case JUNE, JULY, AUGUST -> Season.SPRING;
            case SEPTEMBER, OCTOBER, NOVEMBER -> Season.FALL;
            case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;
        };
    }

    public static String getWeather(Season value) {
        return switch(value) {
            case WINTER -> "Cold";
            case SPRING -> "Rainy";
            case SUMMER -> "Hot";
            case FALL -> "Warm";
        };
    }
}
