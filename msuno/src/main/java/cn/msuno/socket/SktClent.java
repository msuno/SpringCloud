package cn.msuno.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SktClent {

	public static void main(String[] args) {
		Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket("127.0.0.1", 11111);

            //给服务端发送请求
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String request = "北京";
            dataOutputStream.writeUTF(request);
            
            dataInputStream = new DataInputStream(socket.getInputStream());
            String response = dataInputStream.readUTF();
            System.out.println(response);
        
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(dataInputStream != null){
                    dataInputStream.close();
                }
                if(dataOutputStream != null){
                    dataOutputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
	}
}
