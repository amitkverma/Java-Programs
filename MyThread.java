public class MyThread implements Runnable
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread=new Thread(new MyThread(),"amit");
		thread.start();
		
		System.out.println(Thread.currentThread().getName()+" sleeps for 3s");
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName()+" interrupted thread");
		thread.interrupt();
		System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);         
        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        thread.interrupt();
	}
	@Override	
	public void run()
	{
		try
		{
			Thread.sleep(Long.MAX_VALUE);
		}
		catch(InterruptedException e)
		{
			System.out.println("[ "+Thread.currentThread().getName()+" ] interrupt exception");
		}
		while(!Thread.interrupted())
		{
		}
		System.out.println("[ "+Thread.currentThread().getName()+"] interrupted for second time");	
	}
}