import java.util.Arrays;

public class MaxPQ {
    private int[] pq;//堆
    private int N = 0; //元素个数,存储在[0...N]中

    public MaxPQ(int maxN) {
        pq = new int[maxN];
    }

    public int size() {
        return N;
    }

    public void insert(int a) {
        pq[N] = a;
        swim(N++);
    }

    public int delMax() {
        int max = pq[0];
        swap(0, --N);
        sink(0);
        return max;
    }

    private void swap(int a, int b) {
        int temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private void swim(int k) {
        while (pq[k] > pq[(k - 1) / 2]) {
            swap(k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    public void sink(int k) {
        while (2 * k + 1 <= N - 1) {
            int j = 2 * k + 1;
            if (j < N - 1 && pq[j] < pq[j + 1]) {
                j++;
            }
            if (pq[k] >= pq[j]) {
                break;
            }
            swap(k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        System.out.println(Arrays.toString(a));
        for (int i = 0;i < a.length;i++) {
            a[i] = (int) (100 * Math.random());
        }
        System.out.println(Arrays.toString(a));

        int M = 10;
        MaxPQ pq = new MaxPQ(M + 1);//找到最小的10个元素
        for (int i : a) {
            pq.insert(i);
            if (pq.size() > M) {
                pq.delMax();//如果有M+1个元素，删除其中最大的元素
            }
        }
        for (int j = 0;j < M;j++) {
            while (pq.size() != 0) {
                System.out.print(pq.delMax() + " ");
            }
        }

    }
}
