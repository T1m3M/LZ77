import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		int input;
		Scanner _sc;
		String data;
		LZ77 alg;
		
		System.out.println("Welcome to LZ77 World!");
		
		System.out.println("\nWhat to you want to do?\n1- Compress\n2- Decompress");
		System.out.print("> ");
		
		_sc = new Scanner(System.in);
		input = _sc.nextInt();
		
		if (input == 1) {
			System.out.print("Original Data  : ");
			_sc = new Scanner(System.in);
			data = _sc.nextLine();
			
			// Example: ABAABABAABBBBBBBBBBBBA
			alg = new LZ77(data);
			alg.compress();
		}
		
		else if (input == 2) {
			System.out.print("Compressed Data: ");
			_sc = new Scanner(System.in);
			data = _sc.nextLine();
			
			// Example: <0, 0, 'A'> <0, 0, 'B'> <2, 1, 'A'> <3, 2, 'B'> <5, 3, 'B'> <2, 2, 'B'> <5, 5, 'B'> <1, 1, 'A'>
			alg = new LZ77(data);
			alg.decompress();
		}
	}
}
