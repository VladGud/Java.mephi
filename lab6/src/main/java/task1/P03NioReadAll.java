package task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class P03NioReadAll {
    
    public static void main(String[] args) {
        
        List<String> fileArr;
        Path file =  Paths.get("src/main/java/task1/hamlet.txt");
        try{
            // Read file into array here

            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            lines.stream().filter(x->x.contains("Ros. ")).forEach(System.out::println);
            
            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            lines.stream().filter(x->x.contains("Guil. ")).forEach(System.out::println);



        }catch (IOException e){
          System.out.println("Error: " + e.getMessage());
        }
    } 
}
