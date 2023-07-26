
public class PowerOfTwo {
	
	public boolean isPowerOfTwo(int x) 
	{ 
		if((x & (x-1)) == 0)
			return true;
		else
			return false;		
	}

}
