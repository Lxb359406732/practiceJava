import java.util.Scanner;

public class AlgorithmsTest {

    public int gcd(int p,int q)
    {
        if(q==0)
        {
            return p;
        }
        int r=p%q;
        return gcd(q,r);
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int p=in.nextInt();
        int q=in.nextInt();
        AlgorithmsTest test=new AlgorithmsTest();
        System.out.println(test.gcd(p,q));
    }
}

