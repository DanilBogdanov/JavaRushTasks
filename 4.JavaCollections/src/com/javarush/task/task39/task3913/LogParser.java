package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.nio.file.Path;
import java.util.*;

public class LogParser implements IPQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
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