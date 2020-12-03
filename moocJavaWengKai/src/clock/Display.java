package clock;

public class Display
{
    private int value;
    private int limit;


    public Display(int value,int limit)
    {
        this.limit=limit;
        this.value=value;
    }

    public void increase()
    {
        value++;
        if(value==limit)
        {
            value=0;
        }

    }
    public int getValue()
    {
        return value;
    }
    public static void main(String[] args)
    {

    }
}
