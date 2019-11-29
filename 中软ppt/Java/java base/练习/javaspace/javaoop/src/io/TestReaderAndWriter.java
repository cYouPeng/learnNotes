package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TestReaderAndWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "c:/a/hello.txt";
		try {
			Reader reader = new FileReader(fileName);
			StringBuffer sb = new StringBuffer();
			while(true){
				int ch = reader.read();
				if(ch<0){
					break;
				}
				sb.append((char)ch);
			
			}
			reader.close();
			System.out.println(sb);
			String str = sb.toString().toUpperCase();
			Writer writer = new FileWriter(fileName);
			writer.write(str);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
