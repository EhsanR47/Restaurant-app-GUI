import java.util.ArrayList;

public class restaurant 
{
	private int id=-1,j=0;
	private String name;
	private int capacity;
	private int fund=10000;
	private Food[] foods = new Food[100];
	private Customer[] customers;
	private ArrayList<Waiter> waiters = new ArrayList<Waiter>(); 
	public restaurant(String name, int capacity)
	{
		this.name=name;
		this.capacity=capacity;
		customers = new Customer[capacity];
		cooking("China");
		cooking("Italian");
		cooking("French");
		cooking("Indian");
		cooking("Iranian");
	}
	public restaurant(String name)
	{
		this.name=name;
		capacity=50;
	}
	public void setCapacity(int capacity)
	{
		this.capacity=capacity;
	}
	public void cooking(String nationality)
	{
		for(int i=j;i<=j+19;i++)
		{
			 if(j+0<=i && i<j+5)
			 {
				 foods[i] = new Food(i, 10, 10, nationality, "non-Vegetarian",500);
			 }
			 else if(j+5<=i && i<j+10)
			 {
				 foods[i] = new Food(i, 7, 7, nationality, "non-Vegetarian",300);
			 }
			 else if(j+10<=i && i<j+15)
			 {
				 foods[i] = new Food(i, 5, 5, nationality, "non-Vegetarian",200);
			 }
			 else
			 {
				 foods[i] = new Food(i, 8, 8, nationality, "Vegetarian",400);
			 }
		}
		 j=j+20;
		
	}
	public void settlement(Customer customer)
	{
		setFund(customer.leaving());
	}
	public void CustomerEntry(String nationality, String foodType, String menuType, int money, int vote)
	{
		id++;
		customers[id] = new Customer(id, nationality, foodType, menuType, money, vote);
		customers[id].setMenu(new Menu(foods, customers[id]));
		customers[id].Cost(3);
	}
	public void WaiterEntry(int id, String nationality)
	{
		waiters.add(new Waiter(id, nationality));
	}
	public String getName()
	{
		return name;
	}
	public int getCapacity()
	{
		return capacity;
	}
	public void setFund(int fund)
	{
		this.fund=this.fund+fund;
	}
	public int getFund()
	{
		return fund;
	}
	public Food[] getFoods()
	{
		return foods;
	}
	public Customer[] getCustomers()
	{
		return customers;
	}
	public ArrayList<Waiter> getWaiters()
	{
		return waiters;
	}
	public int getId()
	{
		return id;
	}
}
