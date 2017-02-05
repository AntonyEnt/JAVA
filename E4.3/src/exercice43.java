import java.util.Random;

public class exercice43 {
	
	public static int e43(int x){		
		IllegalArgumentException e = new IllegalArgumentException();
		if (x < 2 || x > 12){
			throw e;
		}
		Random dé1 = new Random();
		Random dé2 = new Random();
		int cpt = 0;
		int resultatDé1 = 0;
		int resultatDé2 = 0;	
		int total = 0;		
		do
		{
			cpt++;
			resultatDé1 = dé1.nextInt(6) + 1;
			resultatDé2 = dé2.nextInt(6) + 1;
			total = resultatDé1 + resultatDé2;
		}
		while (total != x);
		return cpt;
	}
	
	public static void main(String[] args) {
		
		System.out.println(e43(2));
	}

}
