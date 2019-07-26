package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. "
                    + "Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @SuppressWarnings("checkstyle:MissingSwitchDefault")
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            //super.processIncomingMessage(message);
            if (message.contains(": ")) {

                String[] splitMessage = message.split(": ");
                String userName = splitMessage[0];
                String StringMessage = splitMessage[1];
                String format = null;
                switch (StringMessage) {
                    case "дата": {
                        format = "d.MM.YYYY";
                        break;
                    }
                    case "день": {
                        format = "d";
                        break;
                    }
                    case "месяц": {
                        format = "MMMM";
                        break;
                    }
                    case "год": {
                        format = "YYYY";
                        break;
                    }
                    case "время": {
                        format = "H:mm:ss";
                        break;
                    }
                    case "час": {
                        format = "H";
                        break;
                    }
                    case "минуты": {
                        format = "m";
                        break;
                    }
                    case "секунды": {
                        format = "s";
                        break;
                    }

                    default:
                }

                if (format != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat(format);
                    Calendar calendar = new GregorianCalendar();
                    sendTextMessage(String.format("Информация для %s: %s", userName, sdf.format(calendar.getTime())));
                }
            }
        }
    }


    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + ((int) (Math.random() * 100));
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        //System.out.println(botClient.getUserName());
        botClient.run();

    }
}
