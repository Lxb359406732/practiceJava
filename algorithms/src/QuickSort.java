import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i =0;i < arr.length;i++) {
            arr[i] = list.get(i);
        }//打乱数组，消除对输入的依赖
        sort(arr, 0,arr.length-1);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
//        int j = partation(arr, lo, hi);//双向切分，返回切分点
//        sort(arr, lo, j - 1);
//        sort(arr, j + 1, hi);
        int[] j = partation2(arr, lo, hi);//三向切分，返回切分点
        sort(arr, lo, j[0] - 1);
        sort(arr, j[1] + 1, hi);
    }

    public static int partation(int[] arr, int lo, int hi) {//切分1.0
        int i = lo;
        int j = hi;
        int compare = arr[lo];
        while (true) {
            while (arr[i] <= compare) {
                if (i == hi) {
                    break;
                }
                i++;
            }
            while (arr[j] > compare) {
                if (j == lo) {
                    break;
                }
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr,lo,j);
        return j;
    }

    public static int[] partation2(int[] arr, int lo, int hi) {//三向切分
        int i = lo;//i之前为<区域
        int j = hi;//j之后为>区域
        int k = lo;//遍历指针
        int compare = arr[lo];
        while (k <= j) {
            if (arr[k] < compare) {
                swap(arr, i, k);
                i++;
                k++;
            }
            else if (arr[k] == compare) {
                k++;
            }
            else {
                swap(arr, j, k);
                j--;
            }
        }
        return new int[] {i, j};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 10, 10, 5, 5, 8, 9, 7};
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
