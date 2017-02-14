import java.io.*;
import java.util.*;

public class SortingTimeRunner
	{
		private static int sizeArr;
		private static ArrayList<Time> times = new ArrayList<>();

		public static void main(String[] args) throws IOException
			{
				System.out.println("How big would you like the array to be?");
				System.out.println("Note: Best results with an array 1000 or greater.");
				System.out.println("1: 1000");
				System.out.println("2: 10000");
				System.out.println("3: 100000");
				System.out.println("4: 1000000");
				Scanner ui = new Scanner(System.in);
				int in = ui.nextInt();
				if(in == 1)
					{
						sizeArr = 1000;
					}
				else if(in == 2)
					{
						sizeArr = 10000;
					}
				else if(in == 3)
					{
						sizeArr = 100000;
					}
				else
					{
						sizeArr = 1000000;
					}
				String fileName = "LeaderBoard2.txt";
				int[] items = generate();
				Stopwatch time = new Stopwatch();
				QuickSort.qs(items, 0, items.length - 1);
				times.add(new Time("QuickSort", (double) time.elapsedTime()));
				MergeSort.mergeSort(items);
				times.add(new Time("MergeSort", (double) time.elapsedTime()));
				time = new Stopwatch();
				InsertionSort.InsertionSort(items);
				times.add(new Time("InsertionSort", (double) time.elapsedTime()));
				time = new Stopwatch();
				SelectionSort.SelectionSort(items);
				times.add(new Time("SelectionSort", (double) time.elapsedTime()));
				time = new Stopwatch();
				BubbleSort.bubbleSort(items);
				times.add(new Time("BubbleSort", (double) time.elapsedTime()));
				System.out.println("The times in order of fastest to slowest were:");
				time = new Stopwatch();
				Collections.sort(times, Time.timeComparator);
				System.out.printf("%-20s %-20s %-20s\n", "Sort type", "Nano Seconds", "Seconds");
				writer(times);
				for (Time i : times)
					{
						System.out.printf("%-20s %-20s %-20s\n", i.getName(), i.getTime(), i.getTime() / 1000000000.0);
					}
			}
		private static int[] generate()
			{
				int[] temp = new int[sizeArr];
				for (int i = 0; i < sizeArr; i++)
					{
						temp[i] = (int) ((Math.random() * 100));
					}
				return temp;
			}
		private static void writer(ArrayList<Time> t)
		{
			
			for(Time y: t)
				{
//					String fileName = "LeaderBoard2.txt";
					String fileName = y.getName() + sizeArr;
					double p = y.getTime();
					try {
				        BufferedWriter output = new BufferedWriter(new FileWriter(fileName, true));
				        output.newLine();
				        output.append("" + p);
				        output.close();

				    } catch (IOException ex1) {
				        System.out.printf("ERROR writing score to file: %s\n", ex1);
				    }
				}
			
		}
		private static void reader(ArrayList<Time> t)
		{
			for(Time y : t)
				{
			String fileName = y.getName() + sizeArr;
			int highScore = Integer.MAX_VALUE;
			try {
		        BufferedReader reader = new BufferedReader(new FileReader(fileName));
		        String line = reader.readLine();
		        while (line != null)                 // read the score file line by line
		        {
		            try {
		                int score = Integer.parseInt(line.trim());   // parse each line as an int
		                if (score < highScore)                       // and keep track of the largest
		                { 
		                    highScore = score; 
		                }
		            } catch (NumberFormatException e1) {
		                // ignore invalid scores
		                //System.err.println("ignoring invalid score: " + line);
		            }
		            line = reader.readLine();
		        }
		        reader.close();
		        System.out.println(highScore);
		    } catch (IOException ex) {
		        System.err.println("ERROR reading scores from file");
		    }
			
		}
		}
		}
	
