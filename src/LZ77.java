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
	
	private Tag searching(String searchBuff, String lookAheadWin) {
		int position = 0, length = 0;
		char symbol;
		
		if(lookAheadWin.length() > 1) {
			
			if(searchBuff.contains(lookAheadWin)){
				// calculate the offset to the matched string
				position = lookAheadWinStart - searchBuff.indexOf(lookAheadWin);
				
				// get the length it copies
				length = lookAheadWin.length();
			}
			
			else {
				// search for smaller match
				searching(searchBuff, lookAheadWin.substring(0, lookAheadWin.length() - 1));
			}
		}
		
		// get the next symbol letter's character value (the last char in the matched)
		symbol = lookAheadWin.charAt(length);
		
		
		return new Tag(position, length, symbol);
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
			
			
			// searching in search buffer for the largest possible match
			tag = searching(data.substring(searchBuffStart, searchBuffEnd),
							data.substring(lookAheadWinStart, lookAheadWinEnd));
			
			tag.printTag();
			
			break;
			//lookAheadWinStart+=2; // will be dynamic
		}
	}

	public void decompress() {
		
	}
}
