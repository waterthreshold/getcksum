package getcksum;

//import java.awt.BorderLayout;
//import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
//import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//-------------------Component---------------
		JFrame f = new JFrame("ChkSum"); 
		//JFileChooser chooser = new JFileChooser();
		JButton button = new JButton("File"); 
		JButton OK_button = new JButton("OK");
		JLabel label=new JLabel("");
		TextField pathFiled =new TextField(18);; 
		TextField checksumField = new TextField(18);
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JProgressBar progressBar = new JProgressBar();
		//Chksum chk ;
		//String filePath = null;
		//-------------------Component---------------
		
		//-----action listener--------------------
		button.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent ae)  
			{ 
				JFileChooser chooser = new JFileChooser("C:\\Users\\ERIC2\\Desktop\\Flash_Bin");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "*.bin", "bin");
		        chooser.setFileFilter(filter);
		        chooser.showOpenDialog(null); 
		        String filePath=chooser.getSelectedFile().getPath();
		        pathFiled.setText(filePath);
		        checksumField.setText("");
			} 
		});
		OK_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)  
			{ 
				if (pathFiled.getText() != "") {
					try {
						Chksum chk =new Chksum(pathFiled.getText());
						checksumField.setText(chk.getchksum());
						UpdateWorker updateWorker = new UpdateWorker(f, progressBar);  
				        updateWorker.execute();  
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		        
			} 
		});
		//-----action listener--------------------
		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
	    layout.setVerticalGroup(layout.createSequentialGroup()
	            .addComponent(button)
	            .addGroup(layout.createSequentialGroup()
	               .addGroup(layout.createParallelGroup(
	                  GroupLayout.Alignment.LEADING)
	                  .addComponent(pathFiled)
	                 
	               )
	            )    );
	   GroupLayout layout1 = new GroupLayout(panel2);
		layout.setAutoCreateGaps(true);
	    layout1.setVerticalGroup(layout1.createSequentialGroup()
	    		.addComponent(label)
	            .addGroup(layout1.createSequentialGroup()
	               .addGroup(layout1.createParallelGroup(
	                  GroupLayout.Alignment.LEADING)
	            		   .addComponent(checksumField).addComponent(OK_button))
	                 
	               
	            )    );
		
	//	c.setLayout(layout);
		//layout.setAutoCreateGaps(true);
		//layout.setAutoCreateContainerGaps(true);
		
	   
		
	//	f.add (OK_button);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //Container content = f.getContentPane();  
          
        progressBar.setValue(0);  
        progressBar.setStringPainted(true);  
        //Border border = BorderFactory.createTitledBorder("Reading...");  
        //progressBar.setBorder(border);  
        //content.add(progressBar, BorderLayout.SOUTH);  
        f.add (progressBar);
        
        //chk =new Chksum(filePath);
        
        label.setText("Checksum");
        panel1.setLayout(new GridLayout(3,1));
	    panel1.add(panel);
	    panel1.add(panel2);
	    panel1.add(progressBar);
		f.add (panel1);
       // f.add(label);
        f.setSize(395, 149);
        f.setLocationRelativeTo(null);
        f.setVisible(true);  
        
        
	}

}
