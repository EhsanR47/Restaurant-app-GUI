
public class Customer 
{
	private int cost=0;
	private int id;
	private String nationality;
	private String foodType;
	private String menuType;
	private int money;
	private int vote;
	private Menu menu;
	public Customer(int id, String nationality, String foodType, String menuType, int money, int vote)
	{
		this.id=id;
		this.nationality=nationality;
		this.foodType=foodType;
		this.menuType=menuType;
		this.money=money;
		this.vote=vote;
	}
	public void setVote(int vote)
	{
		this.vote=vote;
	}
	public void setMenu(Menu menu)
	{
		this.menu=menu;
	}
	public String getNationality()
	{
		return nationality;
	}
	public String getFoodType()
	{
		return foodType;
	}
	public String getMenuType()
	{
		return menuType;
	}
	public int getId()
	{
		return id;
	}
	public int getMoney()
	{
		return money;
	}
	public int getVote()
	{
		return vote;
	}
	public Menu getMenu()
	{
		return menu;
	}
	public boolean sad()
	{
		if(menu==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int leaving()
	{
		setVote(vote);
		money=money-cost;
		return cost;
	}
	public void Cost(int cost)
	{
		this.cost=this.cost+cost;
	}
	public int getCost()
	{
		return cost;
	}
	
}
