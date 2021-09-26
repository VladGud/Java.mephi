public class main {
    public static void main(String[] args) {
        String b1="aaaa";
        List A;
        Integer b2=1;
        int index=10;
        int index2=1;
        A=new List();
        A.add(b2);
        b2++;
        A.add(b1,index);
        A.add(b2,index2);
        System.out.println(A.size());
        System.out.println(A.remove(index2));
        System.out.println(A.size());
        b2=10;
        System.out.println(A.indexOf(b2));
        System.out.println(A.get(index2));

    }
}
