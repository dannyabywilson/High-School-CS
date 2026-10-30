package files;

public class Day3PrintF {

	public static void main(String[] args) {
		//Whole Numbers
		System.out.printf("%d\n",44);
		System.out.printf("%3d\n",44);
		System.out.printf("%03d\n",44);
		
		//Decimals
		System.out.printf("%f\n",4.4);
		System.out.printf("%.2f\n",4.4);
		System.out.printf("%8.2f\n",4.4);
		
		//Strings/text
		System.out.printf("%s\n", "Team");
		System.out.printf("%-12s%12s\n", "Team","City");
		
		System.out.printf("%10s%5d%5.2f","Daniel",15,2.356);
	}

}
