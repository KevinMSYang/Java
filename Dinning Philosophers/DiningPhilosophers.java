import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DiningPhilosophers 
{
	final Philosopher[] philosophers = new Philosopher[7];	// this number represent how many philosopher seat around table
	
	public static void main(String[] args) throws Exception
	{
		DiningPhilosophers server = new DiningPhilosophers(3000);

		
		
	}
	
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private String line = "";
	public DiningPhilosophers (int port)
	{
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server started");
			System.out.println("Waiting for a client...");
			socket = server.accept();
			System.out.println("Client accepted");
	
			
			Object[] forks = new Object[philosophers.length];	// generate forks object that store the index for philosopher
				
			for (int i = 0; i < forks.length; i++)
			{
				forks[i] = new Object();
			}
				
			for (int i = 0; i < philosophers.length; i++)
			{
				Object leftFork = forks[i];
				Object rightFork = forks[(i+1) % forks.length];
					
				// avoid deadlock so I decide the last philosopher picks up the right fork first
				if (i == philosophers.length -1)
				{
					philosophers[i] = new Philosopher(rightFork, leftFork);
				}
				else
				{
					philosophers[i] = new Philosopher(leftFork, rightFork);
				}
					
				Thread t = new Thread(philosophers[i], "Philosopher " + (i+1));
				t.start();
			}
				
		
	/*		line = in.readUTF();
			if (line.equals("Over"))
			{
				System.out.println(line);
				Thread.currentThread().interrupt();
				socket.close();
				in.close();
			}*/
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
	
	class Philosopher implements Runnable
	{
		// the forks on either side of the philosopher
		private Object leftFork;
		private Object rightFork;
		private boolean exit;
		
		public Philosopher(Object leftFork, Object rightFork)
		{
			this.leftFork = leftFork;
			this.rightFork = rightFork;
		}
		
		
		
		private void doAction(String action) throws InterruptedException
		{
			System.out.println(Thread.currentThread().getName() + " " + action);
			Thread.sleep(((int) (Math.random() * 100)));	// at random amount of time, thread may stop. Simulate philosopher finished eating
		}
		
		
		// this run function may execute multiple times in different location such as in parent or child situation
		// that means, each thread will execute this run function to determine philosopher's action
		@Override
		public void run() 
		{
			//in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			try 
			{
				in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				line = in.readUTF();
				while(!line.equals("Over")) // this while loop at this situation will not terminate since I predefine the protocol for deadlock
				{
					doAction(": Thinking"); // all philosopher think at the step
					synchronized(leftFork) // pick up left fork for first priority
					{
						doAction(": Picked up left fork");
					
						synchronized(rightFork) // if philosopher could use their left fork then it means they can pick up right fork to eat
						{
							doAction(": Picked up right fork - eating");
							doAction(": Put down right fork");
						}
						doAction(": Put down left fork. Back to thinking");	// if philosopher could not user their left fork
																			// it means their neighbor is using
					}
					
				}
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void stop()
		{
			exit = true;
		}
	}
}

/*class Philosopher implements Runnable
{
	// the forks on either side of the philosopher
	private Object leftFork;
	private Object rightFork;
	private boolean exit;
	
	public Philosopher(Object leftFork, Object rightFork)
	{
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	
	
	private void doAction(String action) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep(((int) (Math.random() * 100)));	// at random amount of time, thread may stop. Simulate philosopher finished eating
	}
	
	
	// this run function may execute multiple times in different location such as in parent or child situation
	// that means, each thread will execute this run function to determine philosopher's action
	@Override
	public void run() 
	{
		try 
		{
		    
			while(!exit) // this while loop at this situation will not terminate since I predefine the protocol for deadlock
			{
				doAction(": Thinking"); // all philosopher think at the step
				synchronized(leftFork) // pick up left fork for first priority
				{
					doAction(": Picked up left fork");
					
					synchronized(rightFork) // if philosopher could use their left fork then it means they can pick up right fork to eat
					{
						doAction(": Picked up right fork - eating");
						doAction(": Put down right fork");
					}
					doAction(": Put down left fork. Back to thinking");	// if philosopher could not user their left fork
																		// it means their neighbor is using
				}
			}
		}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
			return;
		}
	}
	
	public void stop()
	{
		exit = true;
	}
}
*/