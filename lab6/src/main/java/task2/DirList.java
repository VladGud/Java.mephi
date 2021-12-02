package task2;

import java.io.File;
import java.util.Arrays;

public class DirList {
  public static void main(String[] args) {


    // Add Try with resources here
    System.out.println("\n=== Dir list ===");
    File[] st = new File("./").listFiles();
    Arrays.stream(st).filter(File::isDirectory).forEach(System.out::println);

  }
}
