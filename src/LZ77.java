import java.util.ArrayList;

public class LZ77 {
	
	private static String data = "";
	private static Tag tag;
	private static ArrayList<Tag> allTags = new ArrayList<Tag>();
	private static int searchBuffStart = 0, searchBuffEnd = 0;
	private static int lookAheadWinStart = 0, lookAheadWinEnd = 0;
	
	// constants
	private static int SEARCH_BUFF_SIZE = 7, LOOK_AHEAD_WIN_SIZE = 15;
	
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
			
			// updating the search buffer and the look ahead window scope
			searchBuffEnd = lookAheadWinStart; // always attached
			
			if(searchBuffEnd < SEARCH_BUFF_SIZE) // search buffer start calculation
				searchBuffStart = 0;
			else
				searchBuffStart = searchBuffEnd - SEARCH_BUFF_SIZE;
			
			if(lookAheadWinStart + LOOK_AHEAD_WIN_SIZE >= data.length()) // search buffer end boundary
				lookAheadWinEnd = data.length();
			else
				lookAheadWinEnd = lookAheadWinStart + LOOK_AHEAD_WIN_SIZE;
			
			System.out.println(data.substring(lookAheadWinStart, lookAheadWinEnd));
			
			lookAheadWinStart+=2;
		}
	}

	public void decompress() {
		
	}
}
