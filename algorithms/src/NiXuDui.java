import java.util.Arrays;

public class NiXuDui {
    private static int[] aux;

    public static int sort(int[] arr) {
        aux = new int[arr.length]; //一次性分配辅助数组空间，单独写一个sort的原因
        return sort(arr,0,arr.length - 1);
    }

    public static int sort(int[] arr,int lo,int hi) {
        if(hi <= lo) {
            return 0;
        }
        int mid = lo + ((hi - lo) >> 1);//右移完成/2操作
        return sort(arr,lo,mid) + sort(arr,mid + 1,hi) + merge(arr,lo,mid,hi);
    }

    public static int merge(int[] arr,int lo,int mid,int hi) {
        int i = lo;//指向aux[]
        int p1 = lo;//指向左半部分首个元素
        int p2 = mid + 1;//指向右半部分首个元素
        int sum = 0;
        while(p1 <= mid && p2 <= hi) {
            if (arr[p1] <= arr[p2]){
                aux[i++] = arr[p2++];
            }
            else {
                sum += hi-p2+1;//计算小和
                aux[i++] = arr[p1++];
            }
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
        return sum;
    }



    public static void main(String[] args) {
        int[] arr = {3,2,4,5,0};
        int ans = NiXuDui.sort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(ans);


    }
}
