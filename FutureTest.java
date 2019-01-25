package Threads_1;

import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class FutureTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Get your base catalog(for example /usr/local/jdk1.6.0/src):");
		String directory = in.nextLine();
		System.out.println("Get keyword(for example volatille):");
		String keyword = in.nextLine();
		
		MathCounter counter = new MathCounter(new File(directory),keyword);
		FutureTask<Integer> task = new FutureTask<>(counter);
		Thread t = new Thread(task);
		t.start();
		try {
			System.out.println("Number of found files " + task.get()+".");
		}
		catch(ExecutionException e) {e.printStackTrace();}
		catch(InterruptedException e) {}

	}

}
