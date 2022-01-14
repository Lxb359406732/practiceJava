public class Partation {

    public static void partation(int[] arr, int num) {
        int lo = 0;//lo指针
        int hi = arr.length - 1;//hi指针
        while(true){
            while (arr[lo] <= num){
                if (lo == arr.length - 1 ) {
                    break;
                }
                lo++;
            }
            while (arr[hi] > num){
                if (hi == 0) {
                    break;
                }
                hi--;
            }
            if (lo >= hi) {
                break;
            }
            swap(arr,lo,hi);
        }
    }

    public static void partation1(int[] arr, int num) {
        int lo = 0;//lo之前为<=区域
        int i = lo ;
        while (i < arr.length) {
            if (arr[i] <= num) {
                swap(arr, lo, i);
                lo++;
                i++;
            }
            else {
                i++;
            }
        }
    }

    public static void partation2(int[] arr, int num) {//三向切分
        int lo = 0;//lo之前为<区域
        int i = lo;
        int hi = arr.length - 1;//hi之后为>区域
        while (i <= hi) {
            if (arr[i] < num) {
                swap(arr, lo, i);
                i++;
                lo++;
            }
            else if (arr[i] == num) {
                i++;
            }
            else {
                swap(arr, hi, i);
                hi--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {0, 10, 10, 5, 5, 8, 9,12, 7};
        partation(arr, 13);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
