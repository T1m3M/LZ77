import java.util.ArrayList;

public class LZ77 {
	
	private static String data = "";
	private static Tag tag;
	private static ArrayList<Tag> allTags = new ArrayList<Tag>();
	
	LZ77(String d){
		data = d;
	}
	
	private void printAllTags() {
		for(int i = 0; i < allTags.size(); i++) {
			allTags.get(i).printTag();
			System.out.print(" ");
		}
		
		System.out.print("\n");
	}

	public void compress() {
		tag = new Tag(1, 2, 'A');
		allTags.add(tag);
		
		tag = new Tag(2, 4, 'B');
		allTags.add(tag);
		
		tag = new Tag(8, 10, 'X');
		allTags.add(tag);
		
		printAllTags();
	}

	public void decompress() {
		System.out.println("Original data: " + data + "!");
	}
}
