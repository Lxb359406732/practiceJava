//题目内容：
//        设计一个表示分数的类Fraction。这个类用两个int类型的变量分别表示分子和分母。
//        这个类的构造函数是：
//        fraction.Fraction(int a, int b)
//        构造一个a/b的分数。
//
//        这个类要提供以下的功能：
//        double toDouble();
//
//        将分数转换为double
//        fraction.Fraction plus(fraction.Fraction r);
//
//        将自己的分数和r的分数相加，产生一个新的Fraction的对象。注意小学四年级学过两个分数如何相加的哈。
//        fraction.Fraction multiply(fraction.Fraction r);
//
//        将自己的分数和r的分数相乘，产生一个新的Fraction的对象。
//        void print();
//
//        将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。如果分数是1/1，应该输出1。当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出。
//
//        注意，在创建和做完运算后应该化简分数为最简形式。如2/4应该被化简为1/2。
//
package fraction;
import java.util.Scanner;

class Fraction {

            private int a;
            private int b;

            Fraction(int a, int b) {
                this.a = a;
                this.b = b;
                simplify();
            }


    void simplify() {
        int n = Math.min(a, b);
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (a % i == 0 & b % i == 0) {
                max = i;
            }
        }
        if (max != 1) {
            a /= max;
            b /= max;
        }

    }

            double toDouble() {
                double c = a * 1.0 / b;
                return c;
            }

            Fraction plus(Fraction r) {
                int fenzi=1;
                int fenmu=1;
                fenzi = a * r.b + b * r.a;
                fenmu = r.b * b;
                return new Fraction(fenzi, fenmu);
            }

            Fraction multiply(Fraction r) {
                int fenzi=1;
                int fenmu=1;
                fenzi = a * r.a;
                fenmu = r.b * b;
                return new Fraction(fenzi, fenmu);
            }

            void print() {
                if (a == 1 && b == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(a + "/" + b);
                }

            }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Fraction a = new Fraction(in.nextInt(), in.nextInt());

        Fraction b = new Fraction(in.nextInt(), in.nextInt());

        a.print();

        b.print();

        a.plus(b).print();

        a.multiply(b).plus(new Fraction(5, 6)).print();

        a.print();

        b.print();

        in.close();

    }
}




