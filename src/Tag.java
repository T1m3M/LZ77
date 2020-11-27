
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
	
	public int getPos() {
		return p;
	}
	
	public int getLen() {
		return l;
	}
	
	public char getSym() {
		return s;
	}
}
