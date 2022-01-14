import java.util.*;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        var a = new LinkedList<String>();
        a.add("amy");
        a.add("carl");
        a.add("erica");

        var b = new LinkedList<String>();
        b.add("bob");
        b.add("doug");
        b.add("frances");
        b.add("gloria");


        System.out.println(a);
        System.out.println(b);
        //merge the word from b into a

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while(bIter.hasNext())
        {
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next();
            if(bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        //remove all words in b from a
        a.removeAll(b);
        System.out.println(a);

    }
}
