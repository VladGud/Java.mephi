import java.util.*;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        String[] arrSplit = name.split(" ");
        ArrayList<String> repet = new ArrayList<>();
        LinkedHashSet<String> need= new LinkedHashSet<>();
        Collections.addAll(repet, arrSplit);
        Collections.addAll(need, arrSplit);
        for(int i=0; i<need.size();i++)
        {
            int count = Collections.frequency(repet, need.toArray()[i]);
            System.out.println(need.toArray()[i] + ": " + count);
        }
        String outhelp=new String();
        for(int i=0; i<need.size(); i++){
            outhelp+=need.toArray()[i]+" ";
        }
        System.out.println("Выходная строка:" + outhelp);
    }
}
