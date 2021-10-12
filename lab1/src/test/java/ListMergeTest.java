import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListMergeTest {

    @Test
    void merge() {
        int[] a = {1, 2, 3, 10, 8, 9, 11, 12, 20, 7, 6};
        int[] c = {51, 42, 13, 0, 18, 19, 71, 32, 30, 27, 26};
        int[] k = {0,1, 2, 3, 6, 7, 8, 9,10, 11, 12, 13,18, 19,20,26,27, 30, 32, 42, 51,71};
        ListMerge list=new ListMerge(a);
        int[] result=list.merge(c);
        for(int i=0; i< k.length; i++)
            assertSame(k[i], result[i]);
    }
}