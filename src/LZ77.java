import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LZ77 {
	
	private static String data = "";
	private int position = 0, length = 0;
	private char symbol;
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
		
		if(lookAheadWin.length() >= 1) {
			
			if(searchBuff.contains(lookAheadWin)){
				
				// calculate the offset to the matched string
				position = lookAheadWinStart - searchBuff.lastIndexOf(lookAheadWin) - searchBuffStart;
				
				// get the length it copies
				length = lookAheadWin.length();
				
			}
			
			// if only one letter is left and not in the dictionary
			else if (lookAheadWin.length() == 1) {
				// reset the values of the previous operation
				// because that's the first occurreance for the letter
				position = 0;
				length = 0;
			}
			
			else {
				// search for smaller match
				searching(searchBuff, lookAheadWin.substring(0, lookAheadWin.length() - 1));
			}
		}
		
		// get the next symbol letter's character value (the last char in the matched)
		if(lookAheadWinStart + length < lookAheadWinEnd)
			symbol = data.charAt(lookAheadWinStart + length);
		else
			symbol = 0; // there's no next symbol

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
			
			allTags.add(tag); // append to allTags list
			
			// move look ahead to the right to compress next data
			lookAheadWinStart += tag.getLen() + 1;
		}
		
		System.out.print("Compressed Data: ");
		printAllTags();
	}
	
	private void parsing(String inTags) {

		
	     String insideTag = inTags.split("[\\\\<\\\\>]")[1];
	     
	     position = Integer.parseInt(insideTag.substring(0, insideTag.indexOf(",")));
	     length = Integer.parseInt(insideTag.substring(insideTag.indexOf(",") + 2, insideTag.lastIndexOf(",")));

	     // check if next symbol is not null ' '
	     if (insideTag.charAt(insideTag.indexOf("'") + 1) != '\'' )
	    	 symbol = insideTag.charAt(insideTag.indexOf("'") + 1);
	     else
	    	 symbol = 0;
	     
	     tag = new Tag(position, length, symbol);
	     allTags.add(tag);
	     
	     // if the previous wan't the last tag
	     if(!inTags.equals("<" + insideTag + ">"))
	    	 parsing(inTags.substring(insideTag.length() + 3)); // 3 = ' ' + '<' + '>'
	}

	public void decompress() {
		
		String original = "";
		int offset, copy;
		
		// loading all data in Tags objects
		parsing(data);
		
		// get each tag to decode
		for(int i = 0; i < allTags.size(); i++) {
			tag = allTags.get(i);
			
			// restoring the data from the tag and concatenating it
			offset = original.length() - tag.getPos();
			copy = offset + tag.getLen();
			original += original.substring(offset, copy) + tag.getSym();
		}
		
		System.out.print("Original Data  : " + original);
	}
}
