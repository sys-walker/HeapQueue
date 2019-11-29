public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        HeapQueue<String, Integer> q = new HeapQueue<>(); // 5-2-9-8-6-7*
        q.add("a", null);
        System.out.println(q.toString());
        q.add("b", 2);
        System.out.println(q.toString());
        q.add("c", 1);
        System.out.println(q.toString());
        q.add("d", 8);
        System.out.println(q.toString());
        q.add("e", 6);
        System.out.println(q.toString());
        q.add("f", 7);
        System.out.println(q.toString());
        System.out.println("\n size of q "+q.size());


        System.out.println(q.getNode());
        q.remove();
        System.out.println(q.getNode());
        q.remove();
        System.out.println(q.getNode());
        q.remove();
        System.out.println(q.getNode());
        q.remove();
        System.out.println(q.getNode());
        q.remove();
        System.out.println(q.getNode());



    }
}
