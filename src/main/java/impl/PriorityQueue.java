package impl;

public class PriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public PriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return (n==0 || pq[1] == null);
    }

    public void push(Key key) {
        pq[++n] = key;
        swim(n);
    }

    public Key pop() {
        if(isEmpty()) {
            throw new NullPointerException("Priority Queue is Empty.");
        }
        Key max = pq[1];
        exchange(1, n--);
        sink(1);
        pq[n+1] = null;
        return max;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) ++j;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k /= 2;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
