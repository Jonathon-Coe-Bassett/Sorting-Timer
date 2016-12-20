
public class Stopwatch
	{
		 long start = System.nanoTime();
		 public Stopwatch() {
		        start = System.nanoTime();
		    } 
		    public double elapsedTime() {
		        long now = System.nanoTime();
		        return ((now - start));
		    }

	}
