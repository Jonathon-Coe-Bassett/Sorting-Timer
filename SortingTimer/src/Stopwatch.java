
public class Stopwatch
	{
		 long start = System.currentTimeMillis();
		 public Stopwatch() {
		        start = System.currentTimeMillis();
		    } 
		    public double elapsedTime() {
		        long now = System.currentTimeMillis();
		        return (now - start);
		    }

	}
