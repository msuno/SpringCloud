package cn.msuno.thread;

import java.util.concurrent.ExecutorService;

public class ThreadPool {
	
	public static void main(String[] args) {
		/**Number of threads = Number of Available Cores / (1 - Blocking Coefficient)
		 * 如果是IO密集型应用，则线程池大小设置为2N+1；
		 * 如果是CPU密集型应用，则线程池大小设置为N+1；
		 * */
		ExecutorService executor = ThreadPoolService.getInstance();
		for(int i = 0; i < 20; i++) {
			executor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(System.currentTimeMillis()/1000);
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
}
