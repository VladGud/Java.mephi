import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static class D {
        public int t;
    }
    public static int stacker(int n){
        return n+stacker(n-1);
    }
    public static void main(String... args) {
        try {
            String[] starr = new String[10];
            starr[10] = "10000";
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println(ae.getMessage());
        }


        try {
            new FileReader(new File("/invalid/file/location"));
        } catch (FileNotFoundException ae) {
            System.out.println(ae.getMessage());
        }
        try {
            D d=null;
            d.t = 10;
        } catch (NullPointerException ae) {
            System.out.println(ae.getMessage());
        }
        try {
            new FileReader(new File("/invalid/file/location"));
        } catch (IOException ae) {
            System.out.println(ae.getMessage());
        }
        try {
            Object x = "VADODARA";
            Integer x1 = (Integer) x;
        } catch (ClassCastException ae) {
            System.out.println(ae.getMessage());
        }
        try {
                int x= 10/0;
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }
        stacker(10000);
        int i=1000;
        while(true) {
        i*=10;
        String[] ss=new String[i];
        ss[i-1]="B"+i;
        }

    }
}
