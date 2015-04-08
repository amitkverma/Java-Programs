/* The Decorator Pattern in this Pattern we will take a example of beverages like DarkRoast, Espresso and other and we will decorate them with Mocha, Whip, Milk,Soy off course the prices will change according to their decoration */ 

public class DecoratorPattern
{
	public static void main(String[] args)
	{
		DarkRoast roast=new DarkRoast();
		roast.description();
		Milk milk=new Milk(roast);
		Mocha moh=new Mocha(roast);
		moh.description();
		milk.description();
	}
}
abstract class Beverage
{
	abstract void description();
	abstract int getPrice();
	abstract String getDescription();
}
interface decoration
{
	abstract void description();;
}
class DarkRoast extends Beverage
{
	int price=10;
	String description="Dark Roast ";
	public void description()
	{
		System.out.println(description+"\nPrice: "+price);
	}
	public int getPrice()
	{
		return price;
	}
	public String getDescription()
	{
		return description;
	}
}
class Espresso extends Beverage
{
	int price=15;
	String description="Espresso ";
	public void description()
	{
		System.out.println(description+"\nPrice: "+price);		
	}
	public int getPrice()
	{
		return price;
	}
	public String getDescription()
	{
		return description;
	}
	
}
class Milk implements decoration
{
	Beverage beverage;
	int price;
	String description;	
	public Milk(Beverage beverage)
	{
		this.beverage=beverage;
		price=beverage.getPrice()+2;
		description=beverage.getDescription()+"with milk ";		
	}
	public void description()
	{
		System.out.println(description+"\nPrice: "+price);
	}
}
class Mocha implements decoration
{
	Beverage beverage;
	int price;
	String description;
	public Mocha(Beverage beverage)
	{
		this.beverage=beverage;
		price=beverage.getPrice()+6;
		description=beverage.getDescription()+"with Mocha";

	}
	public void description()
	{
		System.out.println(description+"Price: "+price);
	}
}