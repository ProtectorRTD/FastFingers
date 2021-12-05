package Front;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Back.ListenerArea;

import java.awt.event.*;


public class Time 
{
    private int i ;
    public Time(JLabel Time, boolean start, ListenerArea listenerArea)
    {
        i = 60;
        javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(i  <= 0) 
                {
                    return;
                    //тут надо сделать так, чтобы jtextarea, нельзя было менять и выводилась статистика
                }
                if(start == true && listenerArea.startTimer() == true)
                {
                    i--;
                    Time.setText(Integer.toString(i));
                }
            }
         });
         t.start();         
    }
    public void setTime(int value)
    {
        i = value;
    }  
    public int getTime()
    {
        return i;
    }
    public void reset()
    {
        i = 60;
    }
    
}
