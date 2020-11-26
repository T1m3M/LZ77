import java.util.ArrayList;

public class LZ77 {
	
	private static String data = "";
	private static Tag tag;
	private static ArrayList<Tag> allTags = new ArrayList<Tag>();
	private static int lookAheadWinStart = 0;
	
	// constants
	private static int SEARCH_BUFF_SIZE = 7, LOOK_AHEAD_WIN_SIZE = 7;
	
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
		
		// while the algorithm still working on data compression
		while(lookAheadWinStart < data.length()) {
			
		}
	}

	public void decompress() {
		
	}
}
