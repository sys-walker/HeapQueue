
import java.time.Instant;
import java.util.*;

public class HeapQueue<V,P extends Comparable<? super P>> implements PriorityQueue<V,P> {

    private final ArrayList<TSPair<V,P>> pairs = new ArrayList<>();

    private int heapSize;
    private long nextTimeStamp = 0L;


    public HeapQueue() {
        this.heapSize=0;
    }


    private static class TSPair<V, P extends Comparable<? super P>> implements Comparable<TSPair<V,P>>  {
        private final V value;
        private  final P priority;
        private long timeStamp;
        public TSPair(V value,P priority,long timeStamp){
            this.value=value;
            this.priority=priority;
            this.timeStamp=timeStamp;

        }

        @Override
        public int compareTo(TSPair<V, P> o) {
            return 0;
        }

        @Override
        public String toString() {
            return "["+value+","+priority+",("+")]";
        }
    }

    @Override
    public void add(V value, P priority) {
        nextTimeStamp = (new Date().getTime()/1000L);

        TSPair<V,P> element = new TSPair<>(value,priority,nextTimeStamp);
        pairs.add(element);
        heapSize+=1;
        makeMaxHeap(pairs,heapSize-1);

    }

    private void makeMaxHeap(ArrayList<TSPair<V,P>> pairs, int i) {

        P auxP = pairs.get(i).priority;
        TSPair<V,P> auxN = pairs.get(i);
        while (hasParent(i) && comparadoreishon(auxP,pairs,i)>0){
            pairs.set(i,pairs.get(parent(i)));
            i = parent(i);
        }
        pairs.set(i,auxN);
    }

    private int comparadoreishon(P auxP, ArrayList<TSPair<V,P>> pairs,int i) {
        //System.out.println("prioritat REF "+auxP);
        //System.out.println("prioritat Nxt "+pairs.get(parent(i)).priority);
        //System.out.println("---------------------->"+auxP.compareTo(pairs.get(parent(i)).priority));
        return auxP.compareTo(pairs.get(parent(i)).priority);
    }

    @Override
    public V remove() {
        return null;
    }

    @Override
    public V element() {
        return null;
    }

    @Override
    public int size() {
        return heapSize;
    }



    public static int parent(int index){return index/2;}
    public static int left(int index){return 2*index+1;}
    public static int right(int index){return 2*index+2;}

    public boolean isValid(int index){return 0<= index && index < size();}
    public boolean hasParent(int index){return index > 0;}
    public boolean hasLeft(int index){return isValid(left(index));}
    public boolean hasRight(int index){return isValid(right(index));}

    @Override
    public String toString() {
        Object[] Queue = pairs.toArray();
        StringBuilder s = new StringBuilder("Queue -");
        for (int i = 0; i < Queue.length; i++) {
            s.append(Queue[i].toString()).append("-");


        }
        return s.toString();
    }
}
