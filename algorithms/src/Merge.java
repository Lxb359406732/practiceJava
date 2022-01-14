import java.util.Arrays;

public class Merge {
    private static int[] aux;

    public static void sort(int[] arr) {
        aux = new int[arr.length]; //一次性分配辅助数组空间，单独写一个sort的原因
        sort(arr,0,arr.length - 1);
    }

    public static void sort(int[] arr,int lo,int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);//右移完成/2操作
        sort(arr,lo,mid);
        sort(arr,mid + 1,hi);
        merge(arr,lo,mid,hi);
    }

    public static void merge(int[] arr,int lo,int mid,int hi) {
        int i = lo;//指向aux[]
        int p1 = lo;//指向左半部分首个元素
        int p2 = mid + 1;//指向右半部分首个元素
        while(p1 <= mid && p2 <= hi) {
            aux[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid) {
            aux[i++] = arr[p1++];
        }
        while(p2 <= hi) {
            aux[i++] = arr[p2++];
        }
        for (i = lo;i < hi +1; i++) {//复制回原数组
            arr[i] = aux[i];
        }
    }



    public static void main(String[] args) {
        int[] arr = {2, 2, 5, 3, 8, 4, 100,-1,0};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
