import java.util.Arrays;

public class XiaoHe {
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
//            aux[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            if (arr[p1] < arr[p2]){
                sum += arr[p1]*(hi-p2+1);//计算小和
                aux[i++] = arr[p1++];
            }
            else {
                aux[i++] = arr[p2++];
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
        int[] arr = {1,3,4,2,5};
        int ans = XiaoHe.sort(arr);
        System.out.println(ans);

    }
}
