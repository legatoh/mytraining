import java.util.Set;

public class Element {
	public final static short NUMBER = 0;

	public final static short BRACKET_OPEN = -1;
	public final static short BRACKET_CLOSE = -2;

	public final static short SIGN_1 = 3;
	public final static short SIGN_2 = 2;
	public final static short SIGN_3 = 1;

	final static Set<String> signSet1 = Set.of("(", ")");
	final static Set<String> signSet2 = Set.of("*", "/", "%", "^");
	final static Set<String> signSet3 = Set.of("+", "-");

	String e;
	short type;

	public Element(String e) {
		super();
		this.e = e;
		typeSet();
	}

	private void typeSet() {
		if (e.equals("(")) {
			this.type = BRACKET_OPEN;
		} else if (e.equals(")")) {
			this.type = BRACKET_CLOSE;
		} else if (signSet2.contains(e)) {
			this.type = SIGN_2;
		} else if (signSet3.contains(e)) {
			this.type = SIGN_3;
		} else {
			this.type = NUMBER;
		}

	}
}
