package chapter3;

public class LinearProbingHashST<Key,Value>
{
    private static final int INIT_CAPACITY=4;

    private int N;//符号表中的键值对总数
    private int M;//线性探测表的大小
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST()
    {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int cap)
    {
        M=cap;
        N=0;
        keys=(Key[]) new Object[M];
        vals=(Value[]) new Object[M];
    }

    private int hash(Key key) {return (key.hashCode()&0x7fffffff)%M;}

    private void resize(int cap)
    {
        LinearProbingHashST<Key,Value> t=new LinearProbingHashST<>(cap);
        for(int i=0;i<M;i++)
        {
            if(keys[i]!=null) {t.put(keys[i],vals[i]);}
        }
        keys= t.keys;
        vals=t.vals;
        M= t.M;
    }

    public void put(Key key,Value val)
    {
        if(N>=M/2) {resize(2*M);}

        int i;
        for(i=hash(key);keys[i]!=null;i=(i+1)%M)
        {
            if(keys[i].equals(key)) {vals[i]=val;return;}
        }
        keys[i]=key;
        vals[i]=val;
        N++;
    }

    public Value get(Key key)
    {
        int i;
        for(i=hash(key);keys[i]!=null;i=(i+1)%M)
        {
            if(keys[i].equals(key)) {return vals[i];}
        }
        return null;
    }
    public boolean contains(Key key) {return get(key)!=null;}

    public void delete(Key key)
    {
        if(!contains(key)) {return;}
        int i=hash(key);
        while(!key.equals(keys[i])) {i=(i+1)%M;}
        keys[i]=null;
        vals[i]=null;
        i=(i+1)%M;
        while(keys[i]!=null)
        {
            Key keyToRedo=keys[i];
            Value valToRedo=vals[i];
            keys[i]=null;
            vals[i]=null;
            N--;
            put(keyToRedo,valToRedo);
            i=(i+1)%M;
        }
        N--;
        if(N>0&&N<=M/8) {resize(M/2);}
    }
}
