package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.nio.file.Path;
import java.util.*;

public class LogParser implements IPQuery, UserQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    /*Реализуй интерфейс UserQuery у класса LogParser:
2.1. Метод getAllUsers() должен возвращать всех пользователей.
2.2. Метод getNumberOfUsers() должен возвращать количество уникальных пользователей.
2.3. Метод getNumberOfUserEvents() должен возвращать количество событий от определенного пользователя.
2.4. Метод getUsersForIP() должен возвращать пользователей с определенным IP.
Несколько пользователей могут использовать один и тот же IP.
2.5. Метод getLoggedUsers() должен возвращать пользователей, которые делали логин.
2.6. Метод getDownloadedPluginUsers() должен возвращать пользователей, которые скачали плагин.
2.7. Метод getWroteMessageUsers() должен возвращать пользователей, которые отправили сообщение.
2.8. Метод getSolvedTaskUsers(Date after, Date before) должен возвращать пользователей, которые решали любую задачу.
2.9. Метод getSolvedTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решали задачу с номером task.
2.10. Метод getDoneTaskUsers(Date after, Date before) должен возвращать пользователей, которые решили любую задачу.
2.11. Метод getDoneTaskUsers(Date after, Date before, int task) должен возвращать пользователей, которые решили задачу с номером task.

*/

    @Override
    public Set<String> getAllUsers() {
        List<Log> logs = Log.getLogs(logDir);
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            users.add(log.getName());
        }
        return users;
    }

    //private Set<String> getUsers(Date after, Date before, String name, )

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        List<Log> logs = Log.getLogs(logDir);
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (log.checkDate(after, before)) {
                users.add(log.getName());
            }
        }
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        List<Log> logs = Log.getLogs(logDir);
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (log.checkDate(after, before) && user.equals(log.getName())) {
                users.add(log.getName());
            }
        }
        return users.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        List<Log> logs = Log.getLogs(logDir);
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (log.checkDate(after, before) && ip.equals(log.getIp())) {
                users.add(log.getName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        List<Log> logs = Log.getLogs(logDir);
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (log.checkDate(after, before) && Event.LOGIN.equals(log.getEvent())) {
                users.add(log.getName());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return null;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return null;
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