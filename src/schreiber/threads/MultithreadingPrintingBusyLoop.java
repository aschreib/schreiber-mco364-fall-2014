package schreiber.threads;

import java.util.concurrent.CountDownLatch;

public class MultithreadingPrintingBusyLoop {

	public static void main(String[] args[]) throws InterruptedException {

		Thread threads[] = new Thread[5];
		final CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0; i < threads.length; i++) {
			final int current = i;
			threads[i] = new Thread() {
				public void run() {
					System.out.println(current);
					latch.countDown();
				}
			};
			threads[i].start();
		}

		// This is a busy loop.
		// A busy loop is when a program is continually checking for a
		// condition.
		// It is typically not a good idea.
		int alive = threads.length;
		while (alive > 0) {
			alive = 0;
			for (int i = 0; i < threads.length; i++) {
				if (threads[i].isAlive()) {
					alive++;
				}
			}
		}
		latch.await();
		System.out.println("finished");

	}

}
