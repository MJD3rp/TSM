//Random Value Everyday
//MJDerp 2020/4/20
package randomvalue;

//Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RandomValue {

 public static void main(String[] args) {
        
        //Finding Out When It's 12am
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 42);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();

        Timer timer = new Timer();
        timer.schedule(new RemindTask(), time);
      
    }
 
    //Task To Run Once It Is 12am
    private static class RemindTask extends TimerTask {
        @Override
        public void run() {
        //Max And Min Values
        int min = 1000;
        int max = 100000;
        //Generate A Random Number
        int random_int = (int) (Math.random() * (max - min + 1) + min); 
        File file = new File("RandomValue/src/randomvalue/NOTD.txt");
        PrintWriter writer = null;
            try {
                writer = new PrintWriter(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RandomValue.class.getName()).log(Level.SEVERE, null, ex);
            }
        writer.print("");
        writer.println(random_int);
        writer.close();
        System.out.println(random_int);
        }
    }
}
    

