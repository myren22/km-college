

//Kyle Myren 60%, Jackie Gray 40%

public class Entry {
	private String name;private String phone;private boolean home;private boolean work;
	public Entry(String aName, String aPhone, boolean aHome, boolean aWork)
	{
		name = aName;
		phone = aPhone;
		home = aHome;
		work = aWork;
	}
	public String getName()
	{
		return name;
	}
	public String getPhone()
	{
		return phone;
	}
	public boolean isHome()
	{
		return home;
	}
	public boolean isWork()
	{
		return work;
	}
	public boolean isEquals(Object o)
	{
		if (o instanceof Entry)
		{
			if(((Entry) o).isHome() == this.isHome())
			{
				if(((Entry) o).isWork() == this.isWork())
				{
					if(((Entry) o).getName().equals(this.getName()))
					{
						if(((Entry) o).getPhone().equals(this.getPhone()))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
