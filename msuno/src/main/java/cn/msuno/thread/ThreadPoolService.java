package cn.msuno.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolService {

private volatile static ExecutorService executor;
	
	public static ExecutorService getInstance() {
		if(executor == null) {
			synchronized(ThreadPoolService.class) {
				executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
			}
		}
		return executor;
	}
}
