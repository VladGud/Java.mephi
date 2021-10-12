import java.util.Arrays;

public class List {
    private Object[] arrayList;
    private int size;

    List() {
        size = 0;
    }

    List(Object a) {
        size = 1;
        arrayList = new Object[1];
        arrayList[0] = a;
    }

    List(Object[] a) {
        size = a.length;
        arrayList = new Object[a.length];
        arrayList = a;
    }
 /**
  *<p>Добавляет новый элемент</p>
  * @param a Объект, который мы добавляем
 */
    void add(Object a) {
        size += 1;
        Object[] l1 = new Object[size];
        for (int k = 0; k < size - 1; k++) {
            l1[k] = arrayList[k];
        }
        l1[size - 1] = a;
        arrayList = l1;
    }
    /**
     *<p>Добавляет новый элемент в определенное место массива</p>
     * @param a Объект, который мы добавляем
     * @param index Место в массиве
     */
    void add(Object a, int index) {
        if (index >= size)
            index = size - 1;
        if (index < 0)
            index = 0;
        size += 1;
        Object[] l1 = new Object[size];
        for (int k = 0, t = 0; k < size; k++, t++) {
            if (k != index)
                l1[k] = arrayList[t];
            else {
                l1[k] = a;
                k++;
            }
        }
        l1[size - 1] = a;
        arrayList = l1;
    }
    /**
     *<p>Ищет индекс опеределенного элемента в массиве</p>
     * @param a Объект, который мы ищем в нашем массиве
     * @return Возвращает индекс элемента
     */
    int indexOf(Object a) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(a))
                return i;
        }
        return -1;
    }
    /**
     *<p>Проверяем наличие элемента</p>
     * @param a Объект, который мы проверяем
     * @return Возвращает true если содержиться
     */
    boolean contains(Object a) {
        if (indexOf(a) >= 0)
            return true;
        return false;
    }
    /**
     *<p>Проверка пустой ли список</p>
     * @return Возвращает true если пустой и false если нет
     */
    boolean isEmpity() {
        if (size == 0)
            return true;
        else return false;
    }
    /**
     *<p>Возвращает размер списка</p>
     */
    int size() {
        return this.size;
    }
    /**
     *<p>Удаляет элемент из массива с опеределенным индексом</p>
     * @param index индекс удаляемого элемента
     * @return Возвращает значение удаляемого элемента
     */
    Object remove(int index) {
        if (index >= size || index < 0)
            return null;
        Object help = arrayList[index];
        Object[] arrayList_help;
        arrayList_help = new Object[size - 1];
        for (int i = 0, l = 0; i < size; i++, l++) {
            if (i != index)
                arrayList_help[l] = arrayList[i];
            else
                l--;

        }
        size--;
        arrayList = new Object[size];
        arrayList = arrayList_help;
        return help;
    }
    /**
     *<p>Возвращает элемент</p>
     * @param index индекс нужного нам элемента
     * @return Возвращает элемент под индексом
     */
    Object get(int index) {
        if (index >= size || index < 0)
            return null;
        return arrayList[index];
    }
    /**
     *<p>Изменяет нужный элеменет</p>
     * @param index индекс нужного нам элемента
     * @param value значение на которое мы поменяем наш элемент в массиве
     */
    void set(int index, Object value) {
        arrayList[index] = value;
    }
    /**
     *<p>Объеденяет наш список с новым в отсортировоном порядке</p>
     * @param head Список с которым мы будем объеденять
     * @return Возвращает итоговый объедененный список
     */
    public Object[] merge(Object[] head){
        Arrays.sort(arrayList);
        Arrays.sort(head);
        int nsize=arrayList.length+head.length;
        Object[] help = new Object[nsize];
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
            if(arrayList[a].hashCode() >= head[h].hashCode())
            {
                help[i]=head[h];
                h++;
            }
            else{
                help[i]=arrayList[a];
                a++;
            }
        }
        arrayList=new Object[nsize];
        arrayList=help;
        return arrayList.clone();
    }
}