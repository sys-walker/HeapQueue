
import java.util.*;

public class HeapQueue<V,P extends Comparable<? super P>> implements PriorityQueue<V,P> {

    private final ArrayList<TSPair<V,P>> pairs = new ArrayList<>();
    private long nextTimeStamp = 0L;


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

    }

    @Override
    public void add(V value, P priority) {

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
        return 0;
    }

    public static int parent(int index){return index/2;}
    public static int left(int index){return 2*index+1;}
    public static int right(int index){return 2*index+2;}

    public boolean isValid(int index){return 0<= index && index < size();}
    public boolean hasParent(int index){return index > 0;}
    public boolean hasLeft(int index){return isValid(left(index));}
    public boolean hasRight(int index){return isValid(right(index));}
}
