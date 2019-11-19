public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("ES CONSIDERA QUE LES PRIORITATAS NO ES REPETEIXEN ");
        HeapQueue<String,Integer> q = new HeapQueue<>();
        q.add("a",5);
        System.out.println(q.toString());
        q.add("a",2);
        System.out.println(q.toString());
        q.add("a",9);
        System.out.println(q.toString());
        q.add("a",8);
        System.out.println(q.toString());
        q.add("a",6);
        System.out.println(q.toString());
        q.add("a",7);
        System.out.println(q.toString());
        System.out.println("\n size of q "+q.size());

    }
}
