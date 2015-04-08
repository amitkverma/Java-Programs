/* Polar Angles */

public class PolarAngles
{
	public static void main(String[] args){
		double input=1.0;
		System.out.println((Math.tan(1/2)*180)/(2*Math.PI));
	}
	public static double calculateCord(int x,int y){
		return (Math.tan((double)y/x)*Math.PI)/180;
	}
}