/* Strategy Pattern in this pattern we will take duck as example 
 * where few docks are made of wooden and plastic and their 
 * properties of flying and quacking will be different from others. */

public class StrategyPattern
{
	public static void main(String[] args)
	{
		PlasticDuck duck1=new PlasticDuck();
		duck1.Display();
		duck1.quack();
		duck1.fly();
		WoodenDuck duck2=new WoodenDuck();
		duck2.Display();
		duck2.fly();
		duck2.quack();
		NormalDuck duck3=new NormalDuck();
		duck3.Display();
		duck3.fly();
		duck3.quack();
	}
}
/* Crating an abstract class that can be inherit by all ducks Abstract class of Duck  */

abstract class Duck
{
	public IFlyAble flyable;
	public IQuackAble quackable;
	
	public void fly()
	{
		flyable.Fly();
	}
	public void quack()
	{
		quackable.Quack();
	}
	abstract public void Display(); // Display varies in all classes
}

/* Since Flying and Quack Property varies in some ducks making an interface of them */
interface IFlyAble
{
	void Fly();
}
interface IQuackAble
{
	void Quack();
}
/* classes implementing the interface for different properties */

class Flyable implements IFlyAble
{
	public void Fly()
	{
		System.out.println("I can fly");
	}
}
class NotFlyable implements IFlyAble
{
	public void Fly()
	{
		System.out.println("I can't fly");
	}
}
class Quackable implements IQuackAble
{
	public void Quack()
	{
		System.out.println("I can Quack");
	}
}
class NotQuackable implements IQuackAble
{
	public void Quack()
	{
		System.out.println("I can't Quack");
	}
}
/* Creating a class of plastic duck */
 
class PlasticDuck extends Duck
{
	public PlasticDuck()
	{
		flyable=new NotFlyable();
		quackable=new Quackable();
	}
	public void Display()
	{
		System.out.println("I am Plastic Duck");
	}
}
/* Creating a class of wooden Duck */

class WoodenDuck extends Duck
{
	public WoodenDuck()
	{
		flyable=new NotFlyable();
		quackable=new NotQuackable();
	}
	public void Display()
	{
		System.out.println("I am Wooden duck");
	}
}
/* Creating a class of normal Duck */

class NormalDuck extends Duck
{
	public NormalDuck()
	{
		flyable=new Flyable();
		quackable=new Quackable();
	}
	public void Display()
	{
		System.out.println("I am normal duck");
	}
}