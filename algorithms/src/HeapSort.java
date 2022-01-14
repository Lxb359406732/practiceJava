import java.util.Arrays;

public class HeapSort {
    public static void sort(int[] a) {
        int N = a.length;
        for(int k = (N - 2) / 2;k >= 0;k--) {
            sink(a, k, N);
        }
        while(N > 0) {
            swap(a, 0, --N);
            sink(a,0, N);
        }
    }

    public static void sink(int[] a, int k, int N) {
        while(2 * k + 1 <= N - 1) {
            int j = 2 * k + 1;
            if(j < N - 1 && a[j] < a[j + 1]) {//找到较大子节点
                j++;
            }
            if (a[k] >= a[j]) {//到位，退出循环
                break;
            }
            swap(a, k, j);
            k = j;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int [100];
        System.out.println(Arrays.toString(a));
        for (int i = 0;i < a.length;i++) {
            a[i] = (int) (100*Math.random());
        }
        System.out.println(Arrays.toString(a));

        sort(a);
        System.out.println(Arrays.toString(a));
        }

    }

