import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;


public class TimerTest
{
    /**
     * @version 1.00 2020.12.23
     * @auther Liu XiaoBo
     */
    public static void main(String[] args)
    {
        var listener = new TimePrinter();

        var timer = new Timer(1000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("At the tone,the time is"
        + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
