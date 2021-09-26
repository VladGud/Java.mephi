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
    public void put(Object key, Object value){
       for(int i=0; i<size;i++){
           if(pars[i].key==key) {
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
    public Object get(Object key){
        for(int i=0; i<size;i++){
            if(pars[i].key==key)
                return pars[i].value;
        }
        return null;
    }
    public Object get(Object key, Object bydefault){
        for(int i=0; i<size;i++){
            if(pars[i].key==key) {
                if (pars[i].value == null)
                    return bydefault;
                else return pars[i].value;
            }
        }
        return null;
    }
    public Object remove(Object key){
        Object need=get(key,1);
        if(need==null)
            return need;
        Par[] help = new Par[size-1];
        for(int i=0; i<size;i++){
            if(pars[i].key!=key)
                help[i]=pars[i];
        }
        pars = new Par[size-1];
        size--;
        pars=help;
        return need;
    }
    public boolean keyContains(Object key){
        for(int i=0; i<size;i++){
            if(pars[i].key==key)
                return true;
        }
        return false;
    }
    public List getKeys(){
        List list=new List();
        for(int i=0; i<size;i++){
            list.add(pars[i].key);
        }
        return list;
    }
    public List getValues(){
        List list=new List();
        for(int i=0; i<size;i++){
            list.add(pars[i].value);
        }
        return list;
    }
    public List getEntries(){
        List list=new List();
        for(int i=0; i<size;i++){
            list.add(pars[i]);
        }
        return list;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        if(size==0)
            return true;
        return false;
    }
}
