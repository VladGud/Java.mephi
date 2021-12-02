package classwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class classwork_1 {
    public static void main(String... argv) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свою строку:");
        String st = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(argv[0]))) {

            long ct = br.lines().filter(x -> x.equals(st)).count();
            if (ct == 0) {
                System.out.println("Данной строки нет в файле");
                return;
            }
            System.out.println("Такая строка есть в файле.\nКоличество таких строк в файле: "+ct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
