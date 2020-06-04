package com.javarush.task.task39.task3913;
/*Класс, который будет отвечать за парсинг логов называется LogParser.
1.1. Добавь в класс LogParser конструктор с параметром Path logDir, где logDir - директория с логами (логов может быть несколько, все они должны иметь расширение log).
1.2. Реализуй интерфейс IPQuery у класса LogParser:
1.2.1. Метод getNumberOfUniqueIPs(Date after, Date before) должен возвращать количество уникальных IP адресов за выбранный период.
Здесь и далее, если в методе есть параметры Date after и Date before, то нужно возвратить данные касающиеся только данного периода (включая даты after и before).
Если параметр after равен null, то нужно обработать все записи, у которых дата меньше или равна before.
Если параметр before равен null, то нужно обработать все записи, у которых дата больше или равна after.
Если и after, и before равны null, то нужно обработать абсолютно все записи (без фильтрации по дате).
1.2.2. Метод getUniqueIPs() должен возвращать множество, содержащее все не повторяющиеся IP. Тип в котором будем хранить IP будет String.
1.2.3. Метод getIPsForUser() должен возвращать IP, с которых работал переданный пользователь.
1.2.4. Метод getIPsForEvent() должен возвращать IP, с которых было произведено переданное событие.
1.2.5. Метод getIPsForStatus() должен возвращать IP, события с которых закончилось переданным статусом.
Требования:
1. В классе LogParser должен быть создан конструктор public LogParser(Path logDir).
2. Класс LogParser должен поддерживать интерфейс IPQuery.
3. Метод getNumberOfUniqueIPs(Date, Date) должен возвращать количество уникальных IP адресов за выбранный период.
4. Метод getUniqueIPs(Date, Date) класса LogParser должен возвращать множество, содержащее все не повторяющиеся IP адреса за выбранный период.
5. Метод getIPsForUser(String, Date, Date) класса LogParser должен возвращать IP адреса, с которых работал переданный пользователь за выбранный период.*/

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class LogParser implements IPQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
    //127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK
    private static class Log {
        private String ip;
        private String name;
        private String Date;
        private Event event;
        private int task;
        private Status status;

        public Log(String ip, String name, String date, Event event, int task, Status status) {
            this.ip = ip;
            this.name = name;
            Date = date;
            this.event = event;
            this.task = task;
            this.status = status;
        }

        public Log(String ip, String name, String date, Event event, Status status) {
            new Log(ip, name, date, event, -1, status);
        }

        public static List<Log> getLogs(Path logDir) {
            List<Log> result = new ArrayList<>();
            try {
                for (Path path : Files.newDirectoryStream(logDir)) {
                    if (Files.isRegularFile(path)) {
                        List<String> lines = Files.readAllLines(path);
                        for (String line : lines) {
                            result.add(parseLine(line));
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("trouble getLogs");
            }
            return result;
        }

        private static Log parseLine(String line) {
            String ip;
            String name;
            String Date;
            Event event;
            int task;
            Status status;

            return null;
        }


    }
}