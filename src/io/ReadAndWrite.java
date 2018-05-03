package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
		    fis = new FileInputStream(new File("D:\\read.txt"));
		    fos = new FileOutputStream(new File("D:\\write.txt"));
		    int ch;
		    while((ch=fis.read()) != -1){
		        System.out.print((char)ch);
		        fos.write(ch);
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if(null != fos){
		        fos.close();
		    }
		    if(null != fis){
		        fis.close();
		    }
		}
	}

}
