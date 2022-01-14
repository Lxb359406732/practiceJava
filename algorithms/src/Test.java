
public class Test implements Comparable<String> {
    public static void test() {
        int i = 1;
        addOne(i);
        System.out.println("i="+i);
    }
    public static void addOne(int i) {
        i++;
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        test();
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}

