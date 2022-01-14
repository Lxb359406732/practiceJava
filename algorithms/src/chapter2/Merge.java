package chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Merge
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(lo>=hi) {return;}
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void merge(Comparable[] a,int lo,int mid,int hi)
    {
        int i=lo,j=mid+1;

        for(int k=lo;k<=hi;k++)
        {
            aux[k]=a[k];
        }
        for(int k=lo;k<=hi;k++)
        {
            if(i>mid)                    {a[k]=aux[j++];}
            else if(j>hi)                {a[k]=aux[i++];}
            else if(less(aux[i],aux[j])) {a[k]=aux[i++];}
            else                         {a[k]=aux[j++];}
        }
    }

    private static boolean less(Comparable v,Comparable w)
    {
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j)
    {
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private static void show(Comparable[] a)
    {
        //在单行中打印数组
        for(int i=0;i<a.length;i++)
            StdOut.print(a[i]+" ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        //测试数组元素是否有序
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

    public static void main(String[] args)
    {
        //从标准输入读取字符串，将它们排序并输出
        String[] a=In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

