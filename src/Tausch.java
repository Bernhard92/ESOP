
public class Tausch {
	public static void main(String[] args) {
		int i = 8;
		int j = 5; 
		
		i -= j;
		j = j + i; 
		i = j - i; 
		
		System.out.println(i);
		System.out.println(j);
	}

}
