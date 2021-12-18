package lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    // Запись чисел в массив из двух и более потоков.
    // Добавление нового элемента должно гарантировать, что массив будет отсортирован

    public static void main(String[] args) {
        ArraySync service = new ArrayWrapper();
        // ExecutorService
        Future<?> a = null;
        ExecutorService executorservice = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 10; i++) {
            int finalI = i+1;
            a = executorservice.submit(new Runnable() {
                public void run() {
                    service.addItem(finalI);
                    service.printArray(finalI);
                    //System.out.println("Threads"+finalI);
                }
            });
        }
       executorservice.shutdown();
        while(!a.isDone())
        {

        }
        System.out.println("#############################################");
        service.printArray(0);
    }
}
