public class Map {
    public static class Par{
        Object key;
        Object value;
        public Par(){
            key=1;
            value=1;
        }
        public Par(Object key, Object value){
            this.key=key;
            this.value=value;
        }
    }
    private Par[] pars;
    private int size;
    public Map(){
        size=0;
    }
    public Map(int size,Par... pars)
    {
        this.pars=pars;
        this.size=size;
    }
    /**
     *<p>Добавляет новый элемент или изменяет уже имеющийся</p>
     * @param key ключ элемента , который мы добавляем
     * @param value значение, которое нужно поместить в нашу map
     */
    public void put(Object key, Object value){
        for(int i=0; i<size;i++){
            if(pars[i].key.equals(key)) {
                pars[i].value = value;
                return;
            }
        }
        Par[] help = new Par[size+1];
        for(int i=0; i<size;i++)
            help[i]=pars[i];
        Par npar=new Par(key, value);
        help[size]=npar;
        size++;
        pars = new Par[size];
        pars=help;
        return;
    }
    /**
     *<p>Возвращает элемент под заданным ключом</p>
     * @param key Ключ, который мы ищем в нашей map
     * @return Элемент под ключом или null
     */
    public Object get(Object key){
        for(int i=0; i<size;i++){
            if(pars[i].key.equals(key))
                return pars[i].value;
        }
        return null;
    }
    /**
     *<p>Возвращает элемент под заданным ключом</p>
     * @param key Ключ, который мы ищем в нашей map
     * @return Элемент под ключом или null если элемента нет в массиве или дефолтное значение, если элемент с заданным ключом есть, но его значение null
     */
    public Object get(Object key, Object bydefault){
        for(int i=0; i<size;i++){
            if(pars[i].key.equals(key)) {
                if (pars[i].value == null)
                    return bydefault;
                else return pars[i].value;
            }
        }
        return null;
    }
    /**
     *<p>Удаляет элемент под ключом</p>
     * @param key Ключ, который мы удаляем
     * @return Значение под ключом
     */
    public Object remove(Object key){
        Object need=get(key,1);
        if(need==null)
            return need;
        Par[] help = new Par[size-1];
        for(int i=0; i<size;i++){
            if(!pars[i].key.equals(key))
                help[i]=pars[i];
        }
        pars = new Par[size-1];
        size--;
        pars=help;
        return need;
    }
    /**
     *<p>Проверяет содержиться ли элемент с заданым ключом</p>
     * @param key Ключ, который мы ищем в нашей map
     * @return true, если содержиться, иначе false
     */
    public boolean keyContains(Object key){
        for(int i=0; i<size;i++){
            if(pars[i].key.equals(key))
                return true;
        }
        return false;
    }
    /**
     *<p>Возвращает список ключей map</p>
     * @return Список ключей, содержащихся в map
     */
    public List getKeys(){
        List list=new List();
        for(int i=0; i<size;i++){
            list.add(pars[i].key);
        }
        return list;
    }
    /**
     *<p>Возвращает список значений</p>
     * @return Список значений, содержащихся в map
     */
    public List getValues(){
        List list=new List();
        for(int i=0; i<size;i++){
            list.add(pars[i].value);
        }
        return list;
    }
    /**
     *<p>Возвращает список пар, ключ и значение</p>
     * @return Список пар, ключ и значение, которые содержаться в map
     */
    public List getEntries(){
        List list=new List();
        for(int i=0; i<size;i++){
            list.add(pars[i]);
        }
        return list;
    }
    /**
     *<p>Возвращает размер</p>
     * @return размер map
     */
    public int size() {
        return size;
    }
    /**
     *<p>Проверка пустая ли map</p>
     * @return true, если пустая, иначе false
     */
    public boolean isEmpty(){
        if(size==0)
            return true;
        return false;
    }
}
