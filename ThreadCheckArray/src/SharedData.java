import java.util.ArrayList;

/**
 * this is a class that contains all the shared data between the threads so they will be able to work on the same array and report to each other
 * @author irbte
 *
 */
public class SharedData 
{
	/**
	* a local  array of integers that we will check if there is a subgroup of numbers that their sum will be equal to b
	 */
	ArrayList<Integer> array = new ArrayList<Integer>();
	/**
	 * the winArray will have true at the indexes that are a part of the solution-their sum will be b
	 */
	private boolean [] winArray;
	/**
	 * the flag tells whether the current thread found a solution or not
	 */
	private boolean flag;
	/**
	 * b is the integer that we want to find a subgroup of numbers that their sum will be its value
	 */
	private final int b;
	/**
	 * Constructor that recieves the array of the integers which will be the input for the problem,and the number b that will be checked for sum
	 * @param array-array of integers as an input for the problem-looking for a subset ob sum b
	 * @param b-the sum that will be looked for
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b;
	}

	public boolean[] getWinArray() 
	{
		return winArray;
	}

	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	public ArrayList<Integer>  getArray() 
	{
		return array;
	}

	public int getB() 
	{
		return b;
	}

	public boolean getFlag() 
	{
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
