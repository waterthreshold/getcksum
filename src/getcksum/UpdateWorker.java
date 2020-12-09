package getcksum;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public  class UpdateWorker extends SwingWorker   
{  
    JProgressBar bar = null;  
    JFrame f=null;  
    public UpdateWorker(JFrame f, JProgressBar bar)  
    {  
        this.bar = bar;  
        this.f = f;  
    }         
      
    @Override  
    protected String doInBackground() throws Exception {  
        Random rdm = new Random();  
        int pv = 0;  
        while(pv<100)  
        {  
            Thread.sleep(500);  
            pv+=50;  
            bar.setValue(pv);  
        }  
        return null;  
    }   
      
    @Override    
    protected void done()   
    {   
       // f.setVisible(false);      
       // f.dispose();  
    }  
}
