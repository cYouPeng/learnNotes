package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args){
		try {
			
			while(true){
				ServerSocket ss = new ServerSocket(9000);
				System.out.println("服务端开始监听8000端口");
				System.out.println("等待连接……");
				Socket socket = ss.accept();
				System.out.println("已建立连接");
				//获取输出流，
				OutputStream os = socket.getOutputStream();
				//获取输入流
				InputStream is = socket.getInputStream();
				//接受请求报文
				System.out.println("接受请求报文");
				int len = is.available();
				byte[] b = new byte[len];
				is.read(b);
				String requestStr = new String(b, "utf-8");
				System.out.println(requestStr);
				
				//发送响应报文
				String responseStr = "hehe\r\n";
				os.write(responseStr.getBytes("utf-8"));
				os.flush();
				
				System.out.println("响应报文发送完毕");
				is.close();
				os.close();
				socket.close();
				ss.close();	
			}
//					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
