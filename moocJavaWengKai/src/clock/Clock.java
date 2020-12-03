package clock;
import java.util.Scanner;

public class Clock
{

    private Display second;
    private Display minute;
    private Display hour;

    public Clock(int hour,int minute,int second)
    {
        this.second=new Display(second,60);
        this.minute=new Display(minute,60);
        this.hour=new Display(hour,24);
    }

    public void tick()
    {
        second.increase();
        if(second.getValue()==0)
        {
            minute.increase();
            if(minute.getValue()==0)
            {
                hour.increase();
            }
        }
    }

    public String toString()
    {
        String time="%02d:%02d:%02d";
        String format=String.format(time,hour.getValue(),minute.getValue(),second.getValue());
        return format;
    }

    public static void main(String[] args)
    {
        java.util.Scanner in = new java.util.Scanner(System.in);
        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
        System.out.println(clock);
        clock.tick();
        System.out.println(clock);
        in.close();
    }
}
