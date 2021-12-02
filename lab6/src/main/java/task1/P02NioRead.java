package task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {
    
    public static void main(String[] args) {
        Path filePath = Paths.get("src/main/java/task1/hamlet.txt");
        try{ // Create Try with Resources here
            
            System.out.println("\n=== Entire File ===");
            // print lines here
            byte[] bytes = Files.readAllBytes(filePath);
            String text = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(text);
            
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
