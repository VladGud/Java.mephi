package lab;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayWrapper implements ArraySync {

    private final int[] array = new int[1000];
    private int size = 0;

    @Override
    public boolean addItem(int item) {
        Random random = new Random();
        //int item = random.nextInt(200-val);
        if(size<1000) {
            if (size == 0) {
                array[size] = item;
                size+=1;
            } else {
                int i = 0;
                while (array[i] < item && size > i) {
                    i++;
                }
                if (i == size)
                    array[size] = item;
                else {
                    int tmp_last = array[i];
                    int tmp_current;
                    for (int j = i+1; j <= size; j++) {
                        tmp_current = array[j];
                        array[j]=tmp_last;
                        tmp_last=tmp_current;
                    }
                }
                size += 1;
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void printArray(int i) {
        java.util.Arrays.stream(array, 0, size)
                .forEach(System.out::println);
        System.out.println("######################Threads "+i+"########################");
    }
}
