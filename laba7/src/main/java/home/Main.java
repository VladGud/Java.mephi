package home;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static final CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();

    /**
     * Используя ExecutorService создать 2 потока, которые пишут в list.
     * В потоках, после каждого добавления, в конце метода вызывать Thread.sleep(3000)
     */
    public static void main(String[] args) {
        //ExecutorService
        Future<?> a = null;
        ExecutorService executorservice = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Integer finalI = i%2;
            a = executorservice.submit(new Runnable() {
                public void run() {
                    list.add(finalI);
                    //list.forEach(System.out::println);
                    System.out.println("Threads" + finalI);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorservice.shutdown();
        while(!a.isDone())
        {

        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        list.forEach(System.out::println);
    }

}
