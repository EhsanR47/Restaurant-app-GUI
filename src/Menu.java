
public class Menu 
{
	private Food[] restaurantFoods = new Food[20];
	private Food[] restaurantFoods1 = new Food[5];
	private Customer myCustomers;
	public Menu(Food[] restaurantFoods,Customer myCustomers)
	{
		if(myCustomers.getMenuType().equals("China"))
		{
			if(myCustomers.getFoodType().equals("non-Vegetarian"))
			{
				System.arraycopy(restaurantFoods, 0, this.restaurantFoods, 0, 20);
			}
			else
			{
				System.arraycopy(restaurantFoods, 15, restaurantFoods1, 0, 5);
			}
		}
		else if(myCustomers.getMenuType().equals("Italian"))
		{
			
			if(myCustomers.getFoodType().equals("non-Vegetarian"))
			{
				System.arraycopy(restaurantFoods, 20, this.restaurantFoods, 0, 20);
			}
			else
			{
				System.arraycopy(restaurantFoods, 35, restaurantFoods1, 0, 5);
			}
		}
		else if(myCustomers.getMenuType().equals("French"))
		{
			
			if(myCustomers.getFoodType().equals("non-Vegetarian"))
			{
				System.arraycopy(restaurantFoods, 40, this.restaurantFoods, 0, 20);
			}
			else
			{
				System.arraycopy(restaurantFoods, 55, restaurantFoods1, 0, 5);
			}
		}
		else if(myCustomers.getMenuType().equals("Indian"))
		{
			if(myCustomers.getFoodType().equals("non-Vegetarian"))
			{
				System.arraycopy(restaurantFoods, 60, this.restaurantFoods, 0, 20);
			}
			else
			{
				System.arraycopy(restaurantFoods, 75, restaurantFoods1, 0, 5);
			}
		}
		else if(myCustomers.getMenuType().equals("Iranian"))
		{
			if(myCustomers.getFoodType().equals("non-Vegetarian"))
			{
				System.arraycopy(restaurantFoods, 80, this.restaurantFoods, 0, 20);
			}
			else
			{
				System.arraycopy(restaurantFoods, 95, restaurantFoods1, 0, 5);
			}
		}
		
		this.myCustomers=myCustomers;
	}
	public void setMyCustomer(Customer myCustomer)
	{
		this.myCustomers=myCustomer;
	}
	public Food[] getMenuFoods()
	{
		if(myCustomers.getFoodType().equals("non-Vegetarian"))
		{
			return restaurantFoods;
		}
		else
		{
			return restaurantFoods1;
		}
		
	}
	public Customer getMyCustomer()
	{
		return myCustomers;
	}
}
