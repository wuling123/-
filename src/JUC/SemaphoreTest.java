package JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore semp = new Semaphore(5);
		for (int i = 0; i < 20; i++) {
			final int no = i;
			Runnable run = new Runnable() {

				@Override
				public void run() {
					try {
						semp.acquire();
						System.out.println("Accessing:" + no);

						Thread.sleep((long) (Math.random() * 10000));
						semp.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			};
			exec.execute(run);
		}
		exec.shutdown();
	}

}
