package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
public class Log {
    private String ip;
    private String name;
    private Date date;
    private Event event;
    private int task;
    private Status status;

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public int getTask() {
        return task;
    }

    public Status getStatus() {
        return status;
    }

    public Log(String ip, String name, Date date, Event event, int task, Status status) {
        this.ip = ip;
        this.name = name;
        this.date = date;
        this.event = event;
        this.task = task;
        this.status = status;
    }

    public static List<Log> getLogs(Path logDir) {
        List<Log> result = new ArrayList<>();
        try {
            for (Path path : Files.newDirectoryStream(logDir)) {
                if (path.toString().endsWith(".log")) {
                    List<String> lines = Files.readAllLines(path);
                    for (String line : lines) {
                        Log log = parseLine(line);
                        if (log != null) {
                            result.add(log);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //192.168.100.2	Vasya Pupkin	30.08.2012 16:08:40	DONE_TASK 15	OK
    private static Log parseLine(String line) {
        Pattern patternIp = Pattern.compile("(?<ip>\\d+\\.\\d+\\.\\d+\\.\\d+)\\s" +
                "(?<name>[\\w\\s]+)\\s" +
                "(?<date>\\d+\\.\\d+\\.\\d+\\s\\d+:\\d+:\\d+)\\s" +
                "(?<event>[A-z_]+)\\s" +
                "(?<task>\\d*)\\s?" +
                "(?<status>[A-z_]+)");
        try {
            Matcher matcher = patternIp.matcher(line);

            if (matcher.find()) {
                String ip = matcher.group("ip");
                String name = matcher.group("name");
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                Date date = format.parse(matcher.group("date"));
                Event event = Event.valueOf(matcher.group("event"));
                String stringTask = matcher.group("task");
                int task = ("".equals(stringTask)) ? 0 : Integer.parseInt(stringTask);
                Status status = Status.valueOf(matcher.group("status"));
                return new Log(ip, name, date, event, task, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean checkDate(Date after, Date before) {
        boolean isAfter = false;
        boolean isBefore = false;

        if (after == null || date.after(after)) {
            isAfter = true;
        }

        if (before == null || date.before(before)) {
            isBefore = true;
        }
        return isAfter && isBefore;
    }

    @Override
    public String toString() {
        return "Log{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", event=" + event +
                ", task=" + task +
                ", status=" + status +
                '}';
    }
}
