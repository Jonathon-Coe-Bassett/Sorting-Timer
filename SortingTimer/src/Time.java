
public class Time
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
	}
