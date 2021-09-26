import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void put() {
        Map map = new Map();
        map.put(10,"aa");
        assertFalse(map.isEmpty());
        assertEquals("aa", map.get(10));
    }

    @Test
    void get() {
        Map map = new Map();
        map.put(10,"aa");
        assertEquals("aa", map.get(10));
        assertNull(map.get(11));
    }

    @Test
    void testGet() {
        Map map = new Map();
        map.put(10,"aa");
        assertEquals("aa", map.get(10,"ddd"));
        assertEquals(null, map.get(11,"ddd"));
    }

    @Test
    void remove() {
        Map map = new Map();
        map.put(10,"aa");
        assertFalse(map.isEmpty());
        assertEquals("aa", map.remove(10));
        assertTrue(map.isEmpty());
        map.put(232,"ddd");
        assertNull(map.remove(10));
    }

    @Test
    void keyContains() {
        Map map = new Map();
        map.put(10,"aa");
        assertTrue(map.keyContains(10));
        map.remove(10);
        assertFalse(map.keyContains(10));
    }

    @Test
    void getKeys() {
        Integer[] keys=new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List list=new List(keys);
        Map map=new Map();
        for(int i=0;i<keys.length;i++)
            map.put(keys[i], "a");
        List help = map.getKeys();
        for(int i=0;i<keys.length;i++)
            assertSame(list.get(i), help.get(i));
    }

    @Test
    void getValues() {
        Integer[] keys=new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] values=new Integer[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        List list=new List(values);
        Map map=new Map();
        for(int i=0;i<keys.length;i++)
            map.put(keys[i], values[i]);
        List help = map.getValues();
        for(int i=0;i<values.length;i++)
            assertSame(list.get(i), help.get(i));
    }

    @Test
    void getEntries() {
        Map.Par[] pars =new Map.Par[10];
        String ss="1000";
        for(Integer i=0;i<10;i++)
        {
            Map.Par par = new Map.Par(i,ss);
            pars[i]=par;
        }
        Map map=new Map(10, pars);
        List list = new List(pars);
        List help = map.getEntries();
        for(int i=0;i<pars.length;i++)
            assertSame(list.get(i), help.get(i));
    }

    @Test
    void size() {
        Map map = new Map();
        assertEquals(0,map.size());
        map.put(10,"aa");
        assertEquals(1,map.size());
    }

    @Test
    void isEmpty() {
        Map map = new Map();
        assertTrue(map.isEmpty());
        map.put(10,"aa");
        assertFalse(map.isEmpty());
    }
}