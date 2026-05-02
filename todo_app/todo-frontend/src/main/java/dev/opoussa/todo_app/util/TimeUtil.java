package dev.opoussa.todo_app.util;

public class TimeUtil {
    public static boolean minutesHavePassed(
        Long startTime, int minutes
    ) {
        var now = System.currentTimeMillis();
        var elapsedTime = now - startTime;
        return elapsedTime >= (minutes * 60 * 1000);
    }
}
