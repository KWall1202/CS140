package assignment07;



import java.util.Random;
import java.util.stream.LongStream;

public class P19_1 {
	public static void experiment(boolean isParallel) {
		for(long k=10; k < 1000000000L; k *= 10) {
			LongStream stream = new Random().longs(0,k);
			if(isParallel) stream.parallel();
			long t1 = System.currentTimeMillis();
			long count = stream.filter(x -> x%2==0)
					.limit(k)
					.count();
			long t2 = System.currentTimeMillis();
			System.out.println(count + ": " + (t2-t1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println("----Running Experiment with Sequential Stream----");
		experiment(false);
		System.out.println("----Running Experiment with parallel Stream----");
		experiment(true);
	}

}
