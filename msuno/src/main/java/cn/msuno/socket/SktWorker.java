package cn.msuno.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SktWorker implements Runnable {
	
	private Socket socket;
	
	public SktWorker(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			String request = dataInputStream.readUTF();
			System.out.println("from client..." + request+" 当前线程："+Thread.currentThread().getName());
			// 响应客户端
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			String response = "天气：晴朗，温度：36度";
			dataOutputStream.writeUTF(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		
	}

}
