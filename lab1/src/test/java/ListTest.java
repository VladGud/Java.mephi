import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @org.junit.jupiter.api.Test
    void testAdd() {
        List list=new List(1);
        list.add(4);
        assertEquals(4,list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testAdd1() {
        List list=new List(1);
        list.add(10);
        list.add(20);
        list.add(4,1);
        assertEquals(4,list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testIndexOf() {
        List list=new List(1);
        assertEquals(0, list.indexOf(1));
    }

    @org.junit.jupiter.api.Test
    void testContains() {
        List list =new List(1);
        assertTrue(list.contains(1));
    }

    @org.junit.jupiter.api.Test
    void testIsEmpity() {
        List list= new List();
        assertTrue(list.isEmpity());
    }

    @org.junit.jupiter.api.Test
    void testSize() {
        List list=new List(1);
        list.add(10);
        list.add(20);
        list.add(4,1);
        assertEquals(4,list.size());
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        List list = new List(2);
        list.add(3);
        list.add("asdsd");
        list.remove(2);
        assertFalse(list.contains("asdsd"));
    }

    @org.junit.jupiter.api.Test
    void testGet() {
        List list = new List(1);
        assertEquals(1, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void testSet() {
        List list = new List(1);
        list.set(0, "111");
        assertEquals("111", list.get(0));
    }
}