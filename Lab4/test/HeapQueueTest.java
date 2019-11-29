import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapQueueTest {


    /*@Test
    void parent() {
    }

    @Test
    void left() {
    }

    @Test
    void right() {
    }

    @Test
    void isValid() {
    }

    @Test
    void hasParent() {
    }

    @Test
    void hasLeft() {
    }

    @Test
    void hasRight() {
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void element() {
    }

    @Test
    void size() {
    }*/
    @Test
    void remove_sequence_single_null_priority(){
        HeapQueue<String, Integer> q = new HeapQueue<>();
        q.add("a", null);
        q.add("b", 2);
        q.add("c", 1);
        q.add("d", 8);
        q.add("e", 6);
        q.add("f", 7);

        int num = q.size();
        Object [] actual= new Object[q.size()];
        for (int i = 0; i < actual.length  ; i++) {
            actual[i]=q.remove();

        }
        assertArrayEquals(new Object[]{"d","f","e","b","c","a"},actual);
    }
    @Test
    void add_sequence_single_null_priority(){
        HeapQueue<String, Integer> q = new HeapQueue<>();
        q.add("a", null);
        q.add("b", 2);
        q.add("c", 1);
        q.add("d", 8);
        q.add("e", 6);
        q.add("f", 7);
        String actual = q.toString();
        assertEquals("Queue -[d,8,(3)]-[f,7,(5)]-[e,6,(4)]-[c,1,(2)]-[a,null,(0)]-[b,2,(1)]-",actual);
    }
    @Test
    void add_sequence_no_nulls_priority(){
        HeapQueue<String, Integer> q = new HeapQueue<>();
        q.add("a", 5);
        q.add("b", 2);
        q.add("c", 1);
        q.add("d", 8);
        q.add("e", 6);
        q.add("f", 7);
        String actual = q.toString();
       assertEquals("Queue -[d,8,(3)]-[f,7,(5)]-[e,6,(4)]-[b,2,(1)]-[c,1,(2)]-[a,5,(0)]-",actual);
    }
}