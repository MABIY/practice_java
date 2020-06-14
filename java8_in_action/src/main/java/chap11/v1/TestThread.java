package chap11.v1;

class ThreadDaemonDemo extends Thread {
 
	@Override
	public void run() {
		System.out.println(this + " is daemon " + isDaemon());
		try {
			while (true) {
				Thread.sleep(1);
				System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally "); //this part will not reach 
		}
	}
}
 
public class TestThread {
	public static void main(String args[]) {
		Thread t1 = new ThreadDaemonDemo();
		t1.setDaemon(true);    // setDaemon() must be called before start()
		t1.start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("end ......");
		new Thread(()->{
			try {
				System.out.println("Thread2 start ");
				Thread.sleep(1000);
				System.out.println("Thread2 end ");
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}).start();
	}
}

