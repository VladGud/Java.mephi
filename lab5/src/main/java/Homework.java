import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Homework {
    public static void calculateAge(String name, LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            System.out.println(name + ":\nAge: " + Period.between(birthDate, currentDate).getYears() + '\n' + "Lived days: " + ChronoUnit.DAYS.between(birthDate, currentDate));
        } else {
            System.out.println("Incorrect Date");
        }
    }

    public static void calculateLeapYear(LocalDate birthDate) {
        System.out.println("Benedict Cumberbatch");
        int year = birthDate.getYear();
        boolean leapyear = (
                year > 1584 &&
                        (
                                (year % 400 == 0) ||
                                        (year % 4 == 0 && year % 100 != 0)
                        )
        );
        if (leapyear)
            System.out.println(year + " leap year: 366 days");
        else
            System.out.println(year + " not leap year: 365 days");
        System.out.println("Decades: " + Period.between(birthDate, LocalDate.now()).getYears() / 10);
        LocalDate birthday = LocalDate.of(birthDate.getYear() + 21, birthDate.getMonth(), birthDate.getDayOfMonth());
        System.out.println("Day of week on his 21st birthday: " + birthday.getDayOfWeek());
    }

    public static void train() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        long start = format.parse("01:45 PM").getTime();
        Date enddate = format.parse("07:25 PM");
        long end = enddate.getTime();
        long diff = end - start;
        Calendar cal = Calendar.getInstance();
        cal.setTime(enddate);
        cal.add(Calendar.HOUR, 1);
        cal.add(Calendar.MINUTE, 19);
        System.out.println("Minutes: " + (diff / (60 * 1000)) + " || actual arrival time: " + format.format(cal.getTime()));
    }

    public static void flight() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM:dd hh:mm a");
        Date start = format.parse("03:25 09:15 PM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(Calendar.HOUR, 4);
        cal.add(Calendar.MINUTE, 15);
        System.out.println("It arrive in Mia: " + format.format(cal.getTime()));
        cal.add(Calendar.HOUR, 4);
        cal.add(Calendar.MINUTE, 27);
        System.out.println("Actual arrival time: " + format.format(cal.getTime()));
    }

    public static void school() {
        LocalDateTime t = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 1).atStartOfDay();
        LocalDateTime start = (LocalDateTime) TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY).adjustInto(t);
        LocalDateTime finish = LocalDate.of(LocalDate.now().getYear() + 1, Month.JUNE, 25).atStartOfDay();

        long daysInSchool = Duration.between(start.atOffset(ZoneOffset.UTC), finish.atOffset(ZoneOffset.UTC)).toDays();

        System.out.println("Date: " + start.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY)) + '\n'
                + "Days in school: " + ((daysInSchool / 7) - 4) * 5);
    }

    public static void zoneIdUse() {
        ZoneId BOS = ZoneId.of("America/Los_Angeles");
        ZoneId SFO = ZoneId.of("America/New_York");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");

        System.out.println("Task 2:\n"+ "№ 1\n");
        LocalDateTime startSan = LocalDate.of(2014, Month.JUNE, 13).atTime(22, 30);
        ZonedDateTime flightSan = ZonedDateTime.of(startSan, BOS);
        LocalTime flightTime = LocalTime.of(5, 30);

        System.out.println("What is the local time in Boston when the flight takes off?     " +
                flightSan
                        .toOffsetDateTime()
                        .atZoneSameInstant(SFO)
                        .toLocalTime() +
                "\nWhat is the local time at Boston Logan airport when the flight arrives?    " +
                (flightSan
                        .plusHours(flightTime.getHour())
                        .plusMinutes(flightTime.getMinute()))
                        .toOffsetDateTime()
                        .atZoneSameInstant(SFO)
                        .toLocalTime() +
                "\nWhat is the local time in San Francisco when the flight arrives?    " +
                startSan
                        .plusHours(flightTime.getHour())
                        .plusMinutes(flightTime.getMinute())
        );

        System.out.println("\n№ 2\n");

        LocalDateTime startSan1 = LocalDate.of(2014, Month.JUNE, 28).atTime(22, 30);
        ZonedDateTime flightSan1 = ZonedDateTime.of(startSan, BOS);
        LocalTime flightTime1 = LocalTime.of(22,0);
        LocalDateTime meetingTime = LocalDate.of(2014, Month.JUNE, startSan1.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).getDayOfMonth()).atTime(9, 0);
        ZonedDateTime meetingTimeBLR = ZonedDateTime.of(meetingTime, BLR);

        System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time?    " +
                flightSan1
                        .plusHours(flightTime1.getHour())
                        .toOffsetDateTime()
                        .atZoneSameInstant(BLR)
                        .isBefore(meetingTimeBLR) +
                "\nShe talk: " + flightSan1
                                    .plusHours(flightTime1.getHour())
                                    .toOffsetDateTime()
                                    .atZoneSameInstant(BLR)
                                    .toLocalTime() +
                "\nHe talk: " + flightSan1
                                        .plusHours(flightTime1.getHour())
                                        .toOffsetDateTime()
                                        .toLocalTime());

        System.out.println("\n№ 3\n");

        LocalDateTime startSan2 = LocalDate.of(2014, Month.NOVEMBER, 1).atTime(22, 30);
        ZonedDateTime flightSan2 = ZonedDateTime.of(startSan2, BOS);
        LocalTime flightTime2 = LocalTime.of(5, 30);
        System.out.println("What day and time does the flight arrive in Boston?     " +
                flightSan2
                        .plusHours(flightTime2.getHour())
                        .plusMinutes(flightTime2.getMinute())
                        .toOffsetDateTime()
                        .atZoneSameInstant(SFO)
                        .toLocalDateTime()
        );
    }

    public static void main(String... Args) {
        calculateAge("Lincoln's", LocalDate.of(1809, 2, 12), LocalDate.of(1855, 4, 15));
        System.out.println();
        calculateLeapYear(LocalDate.of(1976, 7, 19));
        System.out.println();
        school();
        System.out.println();
        zoneIdUse();
        System.out.println();
        try {
            train();
            System.out.println();
            flight();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
