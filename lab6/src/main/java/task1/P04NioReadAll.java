package task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class P04NioReadAll {
  public static void main(String[] args) {

    Path file = Paths.get("src/main/java/task1/hamlet.txt");
    try{
        // Read fileinto array here
        List<String> fileArr = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("\n=== Lord Count ===");
        long wordCount = fileArr.stream().filter(x->x.contains("lord")||x.contains("Lord")).count();
        
        System.out.println("Word count: " + wordCount);

        System.out.println("\n=== Prison Count ===");
        wordCount = fileArr.stream().filter(x->x.contains("Prison")||x.contains("prison")).count();
        
        System.out.println("Word count: " + wordCount);            

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}
