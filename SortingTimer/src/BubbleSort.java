
public class BubbleSort
	{
		public static void bubbleSort(int[] intArray)
			{

				int n = intArray.length;
				int temp = 0;

				for (int i = 0; i < n; i++)
					{
						for (int j = 1; j < (n - i); j++)
							{

								if (intArray[j - 1] > intArray[j])
									{
										temp = intArray[j - 1];
										intArray[j - 1] = intArray[j];
										intArray[j] = temp;

									}
							}
					}
			}
		public static void newa(int [] intArray)
		{
			for(int i = 0; i < intArray.length; i++)
				{
					for (int j = 0; j < intArray.length; j++)
						{
							if(intArray[i] > intArray[j])
								{
									int x = intArray[i];
									intArray[i] = intArray[j];
									intArray[j] = x;
								}
						}
				}
		}
	}
