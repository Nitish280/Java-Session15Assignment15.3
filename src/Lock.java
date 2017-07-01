//program to create lock on integer class and string class
public class Lock {
	static class ThreadOne implements Runnable {
		/*
		 * This method request two locks, first String and then Integer
		 */

		public void run() {
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
				}
			}
		}
	}
	/*
	 * This method also requests same two lock but in exactly reverse order i.e.
	 * first Integer and then String. This creates potential deadlock, if one
	 * thread holds String lock and other holds Integer lock and they wait for
	 * each other, forever.
	 */

	static class ThreadTwo implements Runnable {

		public void run() {
			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
				synchronized (Integer.class) {
					System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
				}
			}
		}

	}

	/**
	 * here we create the main method then create the two thread for calling the
	 * method run
	 */
	public static void main(String[] args) {
		new Thread(new ThreadOne(), "ThreadOne").start();
		new Thread(new ThreadTwo(), "ThreadTwo").start();
	}
}
