
public class Tag {
	private int p;  // position
	private int l;  // length
	private char s; // symbol
	
	Tag(int pos, int len, char sym){
		p = pos;
		l = len;
		s = sym;
	}
	
	public void printTag() {
		System.out.print("<" + p + ", " + l + ", '" + s + "'>");
	}
}
