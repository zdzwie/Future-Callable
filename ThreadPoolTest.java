package threadPool;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;


public class ThreadPoolTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner in = new Scanner(System.in)){
		System.out.println("Get your base catalog(for example /usr/local/jdk1.6.0/src):");
		String directory = in.nextLine();
		System.out.println("Get keyword(for example volatille):");
		String keyword = in.nextLine();
		
		ExecutorService pool = Executors.newCachedThreadPool();
		MathCounter counter = new MathCounter(new File(directory),keyword);
		Future<Integer> result = pool.submit(counter);
		
		try {
			System.out.println(result.get()+"matching files");
		}
		catch(ExecutionException e) {e.printStackTrace();}
		catch(InterruptedException e) {}
		pool.shutdown();
		
		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("The biggest size of pool = "+largestPoolSize);

	}
	}
}
