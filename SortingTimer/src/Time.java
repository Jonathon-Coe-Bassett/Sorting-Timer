import java.util.Comparator;
public class Time implements Comparable<Time>
	{
		String name;
		Double time;
		public Time(String q, double b)
		{
			name=q;
			time=b;
		}
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		public Double getTime()
			{
				return time;
			}
		public void setTime(Double time)
			{
				this.time = time;
			}
		public static Comparator<Time> timeComparator=new Comparator<Time>(){
			public int compare(Time arg0, Time arg1)
				{
					if (arg0.getTime() < arg1.getTime()) return -1;
			        if (arg0.getTime() > arg1.getTime()) return 1;
			        return 0;
				}
			};
		@Override
		public int compareTo(Time arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
