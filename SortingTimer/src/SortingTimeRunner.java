import java.util.*;
public class SortingTimeRunner
	{
		private static int sizeArr;
		private static ArrayList<Time> times =new ArrayList<>();
		public static void main(String[] args)
			{
				System.out.println("How big would you like the array to be?");
				System.out.println("Note: Best results with an array 1000 or greater.");
				Scanner ui=new Scanner(System.in);
				sizeArr=ui.nextInt();
				int[] items=generate();
				
				
				Stopwatch time=new Stopwatch();
				qs(items, 0, items.length - 1);
				times.add(new Time("QuickSort",(double) time.elapsedTime()));
				mergeSort(items);
				times.add(new Time("MergeSort",(double) time.elapsedTime()));
				time=new Stopwatch();
				InsertionSort(items);
				times.add(new Time("InsertionSort",(double) time.elapsedTime()));
				time=new Stopwatch();
				SelectionSort(items);
				times.add(new Time("SelectionSort",(double) time.elapsedTime()));
				time=new Stopwatch();
				bubbleSort(items);
				times.add(new Time("BubbleSort",(double) time.elapsedTime()));
				System.out.println("The times in order of fastest to slowest were:");
				time=new Stopwatch();
				Collections.sort(times, Time.timeComparator);
				System.out.printf("%-20s %-20s %-20s\n", "Sort type" , "Nano Seconds" , "Seconds");
				for(Time i: times)
					
						System.out.printf("%-20s %-20s %-20s\n", i.getName() , i.getTime() , i.getTime()/ 1000000000.0);
					}


			
		private static int[] generate()
		{
			int[] temp= new int[sizeArr];
			for(int i=0; i<sizeArr; i++)
				{
					temp[i]=(int)((Math.random()*100));
				}
			return temp;
		}
		public static void SelectionSort ( int [ ] num )
			{
			     int i, j, first, temp;  
			     for ( i = num.length - 1; i > 0; i--)  
			     {
			          first = 0;   //initialize to subscript of first element
			          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
			          {
			               if( num[ j ] < num[ first ] )         
			                 first = j;
			          }
			          temp = num[ first ];   //swap smallest found with element in position i.
			          num[ first ] = num[ i ];
			          num[ i ] = temp; 
			      }           
			}
		public static void InsertionSort( int [ ] num)
			{
			     int j;
			     int key;
			     int i;  

			     for (j = 1; j < num.length; j++)
			    {
			           key = num[ j ];
			           for(i = j - 1; (i >= 0) && (num[ i ] < key); i--)
			          {
			                 num[ i+1 ] = num[ i ];
			          }
			         num[ i+1 ] = key;
			     }
			}
		public static void mergeSort(int [ ] a)
			{
				int[] tmp = new int[a.length];
				mergeSort(a, tmp,  0,  a.length - 1);
			}


			private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
			{
				if( left < right )
				{
					int center = (left + right) / 2;
					mergeSort(a, tmp, left, center);
					mergeSort(a, tmp, center + 1, right);
					merge(a, tmp, left, center + 1, right);
				}
			}


		    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
		    {
		        int leftEnd = right - 1;
		        int k = left;
		        int num = rightEnd - left + 1;

		        while(left <= leftEnd && right <= rightEnd)
		            if(a[left]-a[right] <= 0)
		                tmp[k++] = a[left++];
		            else
		                tmp[k++] = a[right++];

		        while(left <= leftEnd)    
		            tmp[k++] = a[left++];

		        while(right <= rightEnd)
		            tmp[k++] = a[right++];


		        for(int i = 0; i < num; i++, rightEnd--)
		            a[rightEnd] = tmp[rightEnd];
		    }
		 private static void bubbleSort(int[] intArray) 
			 {
             
             int n = intArray.length;
             int temp = 0;
            
             for(int i=0; i < n; i++){
                     for(int j=1; j < (n-i); j++){
                            
                             if(intArray[j-1] > intArray[j]){
                                     temp = intArray[j-1];
                                     intArray[j-1] = intArray[j];
                                     intArray[j] = temp;
                                     
                             }
                     }
             }
		 }
                            

		private static void qs(int items[], int left, int right)
			{
			int i, j;
			int pivot, temp;
			i = left;
			j = right;
			pivot = items [(left + right) / 2];
			do
			{
			while ((items [i] < pivot) && (i < right))
			{
			i++;
			}
			while ((pivot < items [j]) && (j > left))
			{
			j--;
			}
			if (i <= j)
			{
			temp = items [i];
			items [i] = items [j];
			items [j] = temp;
			i++;
			j--;
			}
			}
			while (i <= j);
			if (left < j)
			{
			qs (items, left, j);
			}
			if (i < right)
			{
			qs (items, i, right);
			}
			}

	}
