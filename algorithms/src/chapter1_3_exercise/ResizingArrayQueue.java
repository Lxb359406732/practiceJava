package chapter1_3_exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Iterable<Item>
{
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    private int first = 0;
    private int last = 0;


    public boolean isEmpty(){return N==0;}
    public int size(){return N;}
    private void resize(int cap)
    {
        Item[] temp = (Item[]) new Object[cap];
        for(int i=0;i<N;i++){temp[i]=a[(first+i)%a.length];}
        a=temp;
        first=0;
        last=N;
    }
    public void enqueue(Item item)//使用循环的思想，数组尾部满了继续入列到数组首位
    {
        if(N==a.length){resize(2*a.length);}
        a[last++]=item;
        if(last==a.length){last=0;}
        N++;
    }
    public Item dequeue()
    {
        Item item=a[first++];
        a[first-1]=null;
        N--;
        if(first==a.length){first=0;}
        if(N==a.length/4){resize(a.length/2);}//N==a.length/4避免了全空first超过last的情况
        return item;
    }


    @Override
    public Iterator<Item> iterator() {return new ArrayIterator();}
    private class ArrayIterator implements Iterator<Item>
    {
        private int i=0;
        @Override
        public boolean hasNext() {
            return i<N;
        }

        @Override
        public Item next()
        {
            Item item=a[(i+first)%a.length];
            i++;
            return item;
        }
    }
    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
