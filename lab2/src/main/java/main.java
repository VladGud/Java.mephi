import java.util.*;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        String[] arrSplit = name.split(" ");
        ArrayList<String> repet = new ArrayList<>();
        HashSet<String> need= new HashSet<String>();
        Collections.addAll(repet, arrSplit);
        Collections.addAll(need, arrSplit);
        for(int i=0; i<arrSplit.length;i++)
        {
            int count = Collections.frequency(repet, arrSplit[i]);
            System.out.println(arrSplit[i] + ": " + count);
        }
        String outhelp=new String();
        for(int i=0; i<arrSplit.length;i++)
        {
            int count = Collections.frequency(repet, arrSplit[i]);
        }
        for(int i=0; i<need.size(); i++){
            outhelp+=need.toArray()[i]+" ";
        }
        System.out.println("Выходная строка:" + outhelp);
    }
}
