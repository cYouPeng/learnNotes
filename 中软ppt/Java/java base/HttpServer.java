package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {
	public static void main(String[] args){
		while(true){
		try {
			
			
				ServerSocket ss = new ServerSocket(8000);
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
				System.out.println(len);
				byte[] b = new byte[len];
				is.read(b);
				String requestStr = new String(b, "utf-8");
				System.out.println(requestStr);
			
//				HTTP/1.1 200 ok
//				Accept: text/html
//				Content-type:text/html; charset=utf-8
				StringBuffer responseStr = new StringBuffer("HTTP/1.1 200 ok\r\n");
				responseStr.append("Accept: text/html\r\n");
				responseStr.append("Content-type:text/html; charset=utf-8\r\n\r\n");
				
				responseStr.append("<html>\r\n<body>\r\n<h1>访问成功</h1>\r\n</body>\r\n</html>\r\n");

				//发送响应报文
			
				os.write(responseStr.toString().getBytes("utf-8"));
				os.flush();
				
				System.out.println("响应报文发送完毕");
				is.close();
				os.close();
				socket.close();
				ss.close();	
			
//					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
}
