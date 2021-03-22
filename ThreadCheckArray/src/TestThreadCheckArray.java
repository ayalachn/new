import java.util.ArrayList;
import java.util.Scanner;
/**
 * Gets input from user: array size, array and a number b
 * Generates two threads that check the array
 * when threads finished, main displays to user if there is a sub-array
 * within the given array that the sum of it equals to number b
 * @author Ayala
 */
public class TestThreadCheckArray {
	/**
	 * Get input from user: array length, array elements and number b.
	 * Generates two threads to check the array
	 * @param args - default parameters for main
	 */
	public static void main(String[] args) {
		/**
		 * get input from user
		 */
		try (Scanner input = new Scanner(System.in)) {
			Thread thread1, thread2;
			/**
			 * user enters array size
			 */
			System.out.println("Enter array size");
			int num  = input.nextInt();
			ArrayList<Integer> array = new ArrayList<>();
			System.out.println("Enter numbers for array");
			/**..
			 * user enters array elements
			 */
			for (int index = 0; index < num; index++) 
				array.set(index, input.nextInt());
			/**
			 * user enters a number
			 */
			System.out.println("Enter number");
			num = input.nextInt();
			
			/**
			 * create new SharedData object with the
			 * array and number
			 */
			SharedData sd = new SharedData(array, num);
			
			/**
			 * create two threads & start them
			 */
			thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
			thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
			thread1.start();
			thread2.start();
			try 
			{
				thread1.join();
				thread2.join();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			/**
			 * if there is no sub-array equal to b
			 */
			if (!sd.getFlag())
			{
				System.out.println("Sorry");
				return;
			}
			System.out.println("Solution for b : " + sd.getB() + ",n = " + sd.getArray().length);
			System.out.print("I:    ");
			for(int index = 0; index < sd.getArray().length ; index++)
				System.out.print(index + "    ");
			System.out.println();
			System.out.print("A:    ");
			for (int index : sd.getArray())
			{
				System.out.print(index);
				int counter = 5;
				while (true)
				{
					index = index / 10;
					counter--;
					if (index == 0)
						break;
				}
				for (int i = 0; i < counter; i++)
					System.out.print(" ");
			}

			System.out.println();
			System.out.print("C:    ");
			for (boolean index : sd.getWinArray())
			{
				if (index)
					System.out.print("1    ");
				else
					System.out.print("0    ");	
			}
		}
	}

}
