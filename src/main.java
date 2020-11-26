import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		int input;
		Scanner _sc;
		String data;
		
		System.out.println("Welcome to LZ77 World!");
		
		while(true) {
			System.out.println("\nWhat to you want to do?\n1- Compress\n2- Decompress\n3- Exit");
			System.out.print("> ");
			
			_sc = new Scanner(System.in);
			input = _sc.nextInt();
			
			if (input == 1) {
				System.out.print("Original Data: ");
				_sc = new Scanner(System.in);
				data = _sc.nextLine();
				
				System.out.println(data);
			}
			
			else if (input == 2) {
				System.out.print("Compressed Data: ");
				_sc = new Scanner(System.in);
				data = _sc.nextLine();
				
				System.out.println(data);
			}
			
			else if(input == 3) break;
		}
		
	}

}
