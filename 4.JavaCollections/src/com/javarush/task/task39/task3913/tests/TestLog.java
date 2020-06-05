package com.javarush.task.task39.task3913.tests;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Log;
import com.javarush.task.task39.task3913.LogParser;
import com.javarush.task.task39.task3913.Status;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestLog {
    private static Date after = new Date();
    private static Date before = new Date();
    private static Log log = new Log("146.34.15.5", "Eduard Petrovich Morozko", new Date(), Event.SOLVE_TASK, 14, Status.OK);
    private static Path pathToLogs = Paths.get("4.JavaCollections/src/com/javarush/task/task39/task3913/logs");


    static {
        after.setYear(after.getYear() - 100);
        before.setYear(before.getYear() + 100);
    }

    public static void main(String[] args) throws Exception{

        Event event = Event.valueOf("DONE_TASK");
        System.out.println(event);
    }

    @Test
    public void testMethodCheckDateOfLog() {
        Assert.assertTrue(log.checkDate(after, before));
        Assert.assertFalse(log.checkDate(before, after));
    }

    @Test
    public void testGetNumberOfUniqueIPs() {


    }

}
