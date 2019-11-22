
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
            return (int) (o.timeStamp - this.timeStamp);
        }

        @Override
        public String toString() {
            return "["+value+","+priority+",("+timeStamp+")]";
        }
    }

    private void makeMaxHeap(ArrayList<TSPair<V,P>> pairs, int i) {

        //P auxP = pairs.get(i).priority;  // P auxP = pairs.get(i).priority;
        //System.out.println("priority "+auxP);
        TSPair<V,P> aux = pairs.get(i);
        while (hasParent(i) && priorityComparator(aux,pairs.get(parent(i)))>0){
            pairs.set(i,pairs.get(parent(i)));
            i = parent(i);
        }
        pairs.set(i,aux);
    }
    private int priorityComparator(TSPair<V,P> aux, TSPair<V,P> vptsPair) {

        if (aux.priority != null && vptsPair.priority!=null) { // Les 2 prioritats NO son nules
            if (aux.priority.compareTo(vptsPair.priority)==0){ //Prioritats iguales (comparo el time)
                return aux.compareTo(vptsPair);
            }else{ //les prioritats son diferents
                return aux.priority.compareTo(vptsPair.priority);
            }
        }

        //hi ha alguna propietat nula
        if (aux.priority != null && vptsPair.priority ==null){
            return 1;
        }else if(aux.priority == null && vptsPair.priority !=null){
            return -1;
        }
        return aux.compareTo(vptsPair);
    }




    private void rebuildMaxHeap(ArrayList<TSPair<V, P>> pairs) {
        int index = 0;
        while (hasLeft(index)) {
            int smallNode = left(index);



            if (hasRight(index) && priorityComparator(pairs.get(right(index)), pairs.get(left(index))) > 0) {
                smallNode = right(index);

            }
            if (priorityComparator(pairs.get(index), pairs.get(smallNode)) > 0) {
                break;
            } else {
                swap(index, smallNode);

            }
            index = smallNode;

        }
    }
    private void swap(int i, int j) {
        TSPair<V, P> Aux = pairs.get(i);
        pairs.set(i, pairs.get(j));
        pairs.set(j, Aux);
    }



    public static int parent(int index){return index/2;}
    public static int left(int index){return 2*index+1;}
    public static int right(int index){return 2*index+2;}
    public boolean isValid(int index){return 0<= index && index < size();}
    public boolean hasParent(int index){return index > 0;}
    public boolean hasLeft(int index){return isValid(left(index));}
    public boolean hasRight(int index){return isValid(right(index));}


    @Override
    public void add(V value, P priority) {
        TSPair<V,P> element = new TSPair<>(value,priority,nextTimeStamp);
        pairs.add(element);
        nextTimeStamp ++;
        heapSize+=1;
        makeMaxHeap(pairs,heapSize-1);

    }
    @Override
    public V remove() {
        V value = pairs.get(0).value;
        pairs.set(0, pairs.get(heapSize - 1));
        pairs.remove(heapSize - 1);
        heapSize--;
        rebuildMaxHeap(pairs);
        return value;
    }
    @Override
    public V element() {
        return pairs.get(0).value;
    }
    @Override
    public int size() {
        return heapSize;
    }


    @Override
    public String toString() {
        Object[] Queue = pairs.toArray();
        StringBuilder s = new StringBuilder("Queue -");
        for (int i = 0; i < Queue.length; i++) {
            s.append(Queue[i].toString()).append("-");


        }
        return s.toString();
    }
//for debug
    public String getNode() {
        return pairs.get(0).toString();
    }
}
