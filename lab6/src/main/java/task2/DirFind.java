package task2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class DirFind {
    
    public static void main(String[] args) {

        // Add try with resources

        System.out.println("\n=== Find all dirs ===");
        File[] st = new File("./").listFiles();
        Arrays.stream(st).filter(File::isDirectory).forEach(System.out::println);

    }
}
