
public class Waiter 
{
	private int id;
	private int counter=0;
	private int salary=0;
	private int customers=0;
	private String nationality;
	public Waiter(int id, String nationality)
	{
		this.id=id;
		this.nationality=nationality;
	}
	public void incrementCustomers()
	{
		customers++;
	}
	public void setSalary(int salary)
	{
		
			if(salary==3)
			{
				this.salary=this.salary+salary;
			}
			else
			{
				this.salary=this.salary+salary;
				counter++;
			}
		
	}
	public int getId()
	{
		return id;
	}
	public void setCounter(int counter)
	{
		this.counter=counter;
	}
	public int getCounter()
	{
		return counter;
	}
	public String getNationality()
	{
		return nationality;
	}
	public int getSalary()
	{
		return salary;
	}
	public int getCustomers()
	{
		return customers;
	}
}
