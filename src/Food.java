
public class Food 
{
	private int cost;
	private int number=10;
	private int id;
	private int quality;
	private int internationalQuality;
	private String nationality;
	private String foodType;
	public Food(int id, int quality, int internationalQuality, String nationality, String foodType, int cost)
	{
		this.id=id;
		this.quality=quality;
		this.internationalQuality=internationalQuality;
		this.nationality=nationality;
		this.foodType=foodType;
		this.cost=cost;
	}
	public void setNumber(int number)
	{
		this.number=this.number-number;
	}
	public void setQuality(int quality)
	{
		this.quality=quality;
	}
	public void setInternatinalQuality(int internationalQuality)
	{
		this.internationalQuality=internationalQuality;
	}
	public String getNationality()
	{
		return nationality;
	}
	public int getId()
	{
		return id;
	}
	public int getQuality()
	{
		return quality;
	}
	public int getInternationalQuality()
	{
		return internationalQuality;
	}
	public int getNumber()
	{
		return number;
	}
	public String getFoodType()
	{
		return foodType;
	}
	public int getCost()
	{
		return cost;
	}
	public boolean isFinished()
	{
		if(number==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
