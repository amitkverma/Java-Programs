/* Observer Pattern in this pattern we will take a example of weather station which provides the data of temperature, pressure and humidity of environment which is provided to all other subscribers( general display, statistical display) of weather station */

import java.util.ArrayList;

public class ObserverPattern
{
	public static void main(String[] args)
	{
		WeatherStation station=new WeatherStation();
		GeneralDisplay display=new GeneralDisplay();
		StatisticalDisplay display2=new StatisticalDisplay();
		station.addObserver(display);
		station.addObserver(display2);
		station.updateValues(45,56,4.11f);
		station.updateValues(78,23,9.2f);
	}
}
/* we need two interfaces one for represent of Subject( weather station) and other for observer( general display, statistical display) */

interface ISubject  
{
	void addObserver(IObserver o);
	void removeObserver(IObserver o);
	void notifyObserver();
}

interface IObserver
{
	void update(int temperature,int pressure,float humidity);
}
/* implementing Subject interface */

class WeatherStation implements ISubject
{
	int temperature=0;
	int pressure=0;
	float humidity=0;
	ArrayList<IObserver> list;
	public WeatherStation()
	{
		list=new ArrayList<IObserver>();
	}
	public void addObserver(IObserver o)
	{
		if(o!=null && !list.contains(o))
		{
			list.add(o);
		}
	}
	public void removeObserver(IObserver o)
	{
		if(list.contains(o)&&!list.isEmpty())
		{
			list.remove(o);
		}
	}
	public void notifyObserver()
	{
		if(!list.isEmpty())
		{
			for(int i=0;i<list.size();i++)
			{
				IObserver o=(IObserver)list.get(i);
				o.update(temperature,pressure,humidity);
			}
		}
	}
	public void updateValues(int temperature,int pressure,float humidity)
	{
		this.temperature=temperature;
		this.pressure=pressure;
		this.humidity=humidity;
		notifyObserver();
	}
}

/* implementing Observer interface */

class GeneralDisplay implements IObserver
{
	int temperature;
	float humidity;
	int pressure;
	public void update(int temperature,int pressure,float humidity)
	{
		this.temperature=temperature;
		this.pressure=pressure;
		this.humidity=humidity;
		showDetails();
	}
	public void showDetails()
	{
		System.out.println("General Display station \n Temperature: "+temperature+"\n Pressure: "+pressure+"\n Humidity: "+humidity);
	}
}
class StatisticalDisplay implements IObserver
{
	int temperature;
	int pressure;
	float humidity;
	final int statisticalConstant=39;
	public void update(int temperature,int pressure,float humidity)
	{
		this.temperature=temperature;
		this.pressure=pressure;
		this.humidity=humidity;
		showDetails();
	}
	public void showDetails()
	{
		System.out.println("Statistical Display station \n Temperature: "+temperature*statisticalConstant+"\n Pressure: "+pressure*statisticalConstant+"\n Humidity: "+humidity*statisticalConstant);
	}	
}