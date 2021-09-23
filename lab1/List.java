public class List {
        private Object[] arrayList;
        private int size;
        List(){
            size=0;
        }
        List(Object a) {
            size=1;
            arrayList = new Object[1];
            arrayList[0] = a;
        }
        List(Object[] a) {
            size=a.length;
            arrayList = new Object[a.length];
            arrayList = a;
        }
        void add(Object a) {
            size += 1;
            Object[] l1 = new Object[size];
            for (int k = 0; k < size-1; k++) {
                l1[k] = arrayList[k];
            }
            l1[size-1] = a;
            arrayList = l1;
        }
        void add(Object a, int index){
            if(index>=size)
                index=size;
            size += 1;
            Object[] l1 = new Object[size];
            for (int k = 0, t=0; k < size; k++, t++) {
                if(k!=index)
                    l1[k] = arrayList[t];
                else{
                    l1[k]=a;
                    k++;
                }
            }
            l1[size-1] = a;
            arrayList = l1;
        }
        int indexOf(Object a){
            for(int i=0;i<size;i++) {
                if (arrayList[i] == a)
                    return i;
            }
            return -1;
        }
        boolean contains(Object a){
            if(indexOf(a)>=0)
                return true;
            return false;
        }
        boolean isEmpity(){
            if(size==0)
                return true;
            else return false;
        }
        int size(){
            return this.size;
        }
        Object remove(int index){
            if(index>=size)
                return null;
            Object help = arrayList[index];
            Object[] arrayList_help;
            arrayList_help = new Object[size-1];
            for(int i=0, l=0; i<size; i++, l++)
            {
                if(i!=index)
                    arrayList_help[l]=arrayList[i];
                else
                    l--;

            }
            size--;
            arrayList=new Object[size];
            arrayList=arrayList_help;
            return help;
        }
        Object get(int index){
            if(index>=size)
                return null;
            return arrayList[index];
        }
        void set(int index, Object value){
            arrayList[index]=value;
        }
}
