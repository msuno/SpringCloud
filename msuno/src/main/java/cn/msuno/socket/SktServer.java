package cn.msuno.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import cn.msuno.thread.ThreadPoolService;

public class SktServer {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(11111);
			while(true) {
				Socket socket = ss.accept();
				ThreadPoolService.getInstance().execute(new SktWorker(socket));;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
