import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch
{
    public static int rankIteration(int key,int[] a)
    {
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi)
        {
            int mid =lo+(hi-lo)/2;
            if(key<a[mid]) hi=mid-1;
            else if(key>a[mid]) lo=mid+1;
            else return mid;
        }
        return -1;
    }
    public static int rankRecursion(Integer key,int[] a,int lo,int hi)
    {
        if(hi<lo) {return -1;}
        int mid=lo+(hi-lo)/2;
        int cmp=key.compareTo(a[mid]);
        if(cmp<0)      {return rankRecursion(key,a,lo,mid-1);}
        else if(cmp>0) {return rankRecursion(key,a,mid+1,hi);}
        else           {return mid;}
    }
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty())
        {
            int key=StdIn.readInt();
            if(rankIteration(key,whitelist)<0)
                StdOut.println(key);
        }
    }
}
