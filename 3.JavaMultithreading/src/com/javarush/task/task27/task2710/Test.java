package com.javarush.task.task27.task2710;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception{
        Callable<String> call = () -> {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("call");
            }
            return "finish";
        };

        Callable<String> call2 = () -> {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("<--->");
            }
            return "finish";
        };
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> task = service.submit(call);


        try {
            System.out.println(task.get(2, TimeUnit.SECONDS));

        } catch (Exception e){
            System.out.println("huyarim dalche");
        }
        service.awaitTermination(2, TimeUnit.SECONDS);
        service.submit(call2);
        service.shutdownNow();
        System.out.println(task.get(12, TimeUnit.SECONDS));


    }
}
