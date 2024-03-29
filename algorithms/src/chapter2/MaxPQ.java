package chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N=0;

    public MaxPQ(int maxN)
    {
        pq=(Key[]) new Comparable[maxN+1];
    }

    public void insert(Key v)
    {
        pq[++N]=v;
        swim(N);
    }

    public Key delMax()
    {
        Key max=pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }

    private boolean less(int i,int j)
    {
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch( int i, int j)
    {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k)
    {
        while(k>1&&less(k/2,k))
        {
            exch(k,k/2);
            k=k/2;
        }
    }

    private void sink(int k)
    {
        while(2*k<=N)
        {
            int j=2*k;
            if(j<N&&less(j,j+1)) {j++;}
            if(less(j,k))          {exch(j,k);k=j;}
            else                   {break;}
        }
    }

    public static void main(String[] args)
    {

    }
}
