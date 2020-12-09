package getcksum;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;


public class Chksum {
	int checksum=0;
	//BufferedInputStream reader;
	FileInputStream fis;
	
	public Chksum (String  path) throws FileNotFoundException {
		fis = new FileInputStream (new File(path));
		//BufferedInputStream reader = new BufferedInputStream(fis);
	}
	
	public  String getchksum() throws IOException {
		//int num;
		long  len;
		byte [] buf = new byte[1024];
		while((len= fis.read(buf))!=-1){
			//System.out.println(ch);
			for (int i=0;i<len;i++) {
				int number = buf[i] & 0xff;
				checksum+= number;
				
			}
		}
		String checksum_str="";
		for (int i=3;i>=0;i--) {
			long tmp = (checksum >> (8*i)) &0xff;
			checksum_str+=  Long.toHexString(tmp);
		}
		//System.out.println(checksum_str);
		return "0X"+checksum_str.toUpperCase();
	}
	
	public void close() throws IOException {
		fis.close();
	}
	
}
