import java.util.Arrays;

public class ListMerge {
    private int[] arrayList;
    private int size;
    ListMerge() {
        size = 0;
    }

    ListMerge(int a) {
        size = 1;
        arrayList = new int[1];
        arrayList[0] = a;
    }

    ListMerge(int[] a) {
        size = a.length;
        arrayList = a;
    }
    public int[] merge(int[] head){
        Arrays.sort(arrayList);
        Arrays.sort(head);
        int nsize=arrayList.length+head.length;
        int[] help = new int[nsize];
        int a=0;
        int h=0;
        for(int i = 0; i < nsize; i++)
        {
            if(h>=head.length){
                help[i]=arrayList[a];
                a++;
                continue;
            }
            if(a>=size){
                help[i]=head[h];
                h++;
                continue;
            }
            if(arrayList[a] >= head[h])
            {
                help[i]=head[h];
                h++;
            }
            else{
                help[i]=arrayList[a];
                a++;
            }
        }
        arrayList=help;
        return arrayList.clone();
    }
}
