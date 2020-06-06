package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public Set<Object> execute(String query) {

        Pattern pattern = Pattern.compile("get (?<fieldRes>\\w+)( for (?<fieldPar>\\w+) = \"(?<value>.+?)\"" +
                "( and date between \"(?<after>.*)\" and \"(?<before>.*)\")?)?");
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            String fieldRes = matcher.group("fieldRes");
            String fieldPar = matcher.group("fieldPar");
            String value = matcher.group("value");
            String after = matcher.group("after");
            String before = matcher.group("before");

            return getParamSet(fieldRes, fieldPar, value, after, before);
        }


        return null;
    }

    private Set<Object> getParamSet(String param, String fieldPar, String value,
                                    String after, String before) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date afterDate = null;
        Date beforeDate = null;
        if (after != null) {
            try {
                afterDate = format.parse(after);
                //afterDate.setTime(afterDate.getTime()  + 1);
            } catch (ParseException e) {

            }
        }
        if (before != null) {
            try {
                beforeDate = format.parse(before);
                //beforeDate.setTime(beforeDate.getTime() - 1);
            } catch (ParseException e) {

            }
        }


        String ip = ("ip".equals(fieldPar)) ? value : null;
        String user = ("user".equals(fieldPar)) ? value : null;
        Date date = null;
        if ("date".equals(fieldPar)) {
            try {
                date = format.parse(value);

            } catch (ParseException e) {

            }
        }
        Event event = ("event".equals(fieldPar)) ? Event.valueOf(value) : null;
        Status status = ("status".equals(fieldPar)) ? Status.valueOf(value) : null;

        List<Log> logs;
        logs = getLogs(afterDate, beforeDate, date, ip, user, event, null, status);
//        if (date != null) {
//            logs = getLogs(date, ip, user, event, null, status);
//        } else {
//            logs = getLogs(afterDate, beforeDate, ip, user, event, null, status);
//        }


        switch (param) {
            case "ip":
                Set<String> ips = new HashSet<>();
                for (Log log : logs) {
                    ips.add(log.getIp());
                }
                return new HashSet<>(ips);
            case "user":
                Set<String> users = new HashSet<>();
                for (Log log : logs) {
                    users.add(log.getName());
                }
                return new HashSet<>(users);
            case "date":
                Set<Date> dates = new HashSet<>();
                for (Log log : logs) {
                    dates.add(log.getDate());
                }
                return new HashSet<>(dates);
            case "event":
                Set<Event> events = new HashSet<>();
                for (Log log : logs) {
                    events.add(log.getEvent());
                }
                return new HashSet<>(events);
            case "status":
                Set<Status> statuses = new HashSet<>();
                for (Log log : logs) {
                    statuses.add(log.getStatus());
                }
                return new HashSet<>(statuses);
        }
        return null;
    }

    private Set<String> getUsers(Date after, Date before, String ip, String name,
                                 Event event, Integer task, Status status) {
        List<Log> logs = getLogs(after, before, ip, name, event, task, status);
        Set<String> users = new HashSet<>();

        for (Log log : logs) {
            users.add(log.getName());
        }
        return users;
    }

    private List<Log> getLogs(Date after, Date before, String ip, String name,
                              Event event, Integer task, Status status) {
        List<Log> logs = Log.getLogs(logDir);
        List<Log> filteredLogs = new ArrayList<>();
        for (Log log : logs) {
            if (log.checkDate(after, before) &&
                    (ip == null || ip.equals(log.getIp())) &&
                    (name == null || name.equals(log.getName())) &&
                    (event == null || event.equals(log.getEvent())) &&
                    (task == null || task.equals(log.getTask())) &&
                    (status == null || status.equals(log.getStatus()))) {

                filteredLogs.add(log);
            }
        }
        return filteredLogs;
    }

    private List<Log> getLogs(Date after, Date before, Date date, String ip, String name,
                              Event event, Integer task, Status status) {
        List<Log> logs = Log.getLogs(logDir);
        List<Log> filteredLogs = new ArrayList<>();
        for (Log log : logs) {
            if (log.checkDate(after, before) &&
                    (date == null || date.equals(log.getDate())) &&
                    (ip == null || ip.equals(log.getIp())) &&
                    (name == null || name.equals(log.getName())) &&
                    (event == null || event.equals(log.getEvent())) &&
                    (task == null || task.equals(log.getTask())) &&
                    (status == null || status.equals(log.getStatus()))) {

                filteredLogs.add(log);
            }
        }
        return filteredLogs;
    }

    private Set<Date> getDates(Date after, Date before, String ip, String name,
                               Event event, Integer task, Status status) {
        List<Log> logs = getLogs(after, before, ip, name, event, task, status);
        Set<Date> dates = new HashSet<>();

        for (Log log : logs) {
            dates.add(log.getDate());
        }
        return dates;
    }

    private Set<Event> getEvents(Date after, Date before, String ip, String name,
                                 Event event, Integer task, Status status) {
        List<Log> logs = getLogs(after, before, ip, name, event, task, status);
        Set<Event> events = new HashSet<>();

        for (Log log : logs) {
            events.add(log.getEvent());
        }
        return events;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getEvents(after, before, null, null, null, null, null).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getEvents(after, before, null, null, null, null, null);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getEvents(after, before, ip, null, null, null, null);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getEvents(after, before, null, user, null, null, null);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getEvents(after, before, null, null, null, null, Status.FAILED);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getEvents(after, before, null, null, null, null, Status.ERROR);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getLogs(after, before, null, null, Event.SOLVE_TASK, task, null).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getLogs(after, before, null, null, Event.DONE_TASK, task, null).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        List<Log> logs = getLogs(after, before, null, null, Event.SOLVE_TASK, null, null);
        Map<Integer, Integer> result = new HashMap<>();
        for (Log log : logs) {
            int task = log.getTask();
            if (result.containsKey(task)) {
                result.put(task, result.get(task) + 1);
            } else {
                result.put(task, 1);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        List<Log> logs = getLogs(after, before, null, null, Event.DONE_TASK, null, null);
        Map<Integer, Integer> result = new HashMap<>();
        for (Log log : logs) {
            int task = log.getTask();
            if (result.containsKey(task)) {
                result.put(task, result.get(task) + 1);
            } else {
                result.put(task, 1);
            }
        }
        return result;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getDates(after, before, null, user, event, null, null);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDates(after, before, null, null, null, null, Status.FAILED);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDates(after, before, null, null, null, null, Status.ERROR);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> dates = getDates(after, before, null, user, Event.LOGIN, null, Status.OK);
        if (dates.isEmpty()) {
            return null;
        }
        return Collections.min(dates);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> dates = getDates(after, before, null, user, Event.SOLVE_TASK, task, null);
        if (dates.isEmpty()) {
            return null;
        }
        return Collections.min(dates);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> dates = getDates(after, before, null, user, Event.DONE_TASK, task, null);
        if (dates.isEmpty()) {
            return null;
        }
        return Collections.min(dates);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDates(after, before, null, user, Event.WRITE_MESSAGE, null, Status.OK);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDates(after, before, null, user, Event.DOWNLOAD_PLUGIN, null, Status.OK);
    }

    @Override
    public Set<String> getAllUsers() {
        return getUsers(null, null, null, null,
                null, null, null);
    }


    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getUsers(after, before, null, null, null, null, null).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        List<Log> logs = getLogs(after, before, null, user, null, null, null);
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            events.add(log.getEvent());
        }
        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getUsers(after, before, ip, null, null, null, null);
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUsers(after, before, null, null, Event.LOGIN, null, Status.OK);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUsers(after, before, null, null, Event.DOWNLOAD_PLUGIN, null, Status.OK);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUsers(after, before, null, null, Event.WRITE_MESSAGE, null, Status.OK);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUsers(after, before, null, null, Event.SOLVE_TASK, null, Status.OK);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUsers(after, before, null, null, Event.SOLVE_TASK, task, null);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUsers(after, before, null, null, Event.DONE_TASK, null, Status.OK);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUsers(after, before, null, null, Event.DONE_TASK, task, null);
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        List<Log> logs = Log.getLogs(logDir);
        for (Log log : logs) {
            if (log.checkDate(after, before)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : Log.getLogs(logDir)) {
            if (log.checkDate(after, before) && log.getName().equals(user)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : Log.getLogs(logDir)) {
            if (log.checkDate(after, before) && log.getEvent().equals(event)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : Log.getLogs(logDir)) {
            if (log.checkDate(after, before) && log.getStatus().equals(status)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }


}