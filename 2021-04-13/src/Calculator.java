import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Calculator {
	String inp;
	List<Element> eList = new ArrayList<>();

	public Calculator(String inp) {
		super();
		this.inp = inp;
		analyzeInput();
		calcBracket();
		calcPrio();
		if (eList.size() == 1) {
			System.out.println("=" + eList.get(0).e);
		}
	}

	public void analyzeInput() {
		String[] str = inp.split("", inp.length());

		for (var v : str) {
			eList.add(new Element(v));
		}

		if (eList.get(0).e.equals("-")) {
			eList.set(0, new Element(eList.get(0).e + eList.get(1).e));
			eList.remove(1);
		}

		for (int i = 0; i < eList.size(); i++) {

			if (eList.get(i).type != Element.NUMBER) {
				continue;
			}

			if (i > 1) {
				if (eList.get(i - 1).e.equals("-") && (eList.get(i-2).type == Element.BRACKET_OPEN)) {
					eList.set(i - 1, new Element(eList.get(i - 1).e + eList.get(i).e));
					eList.remove(i);
					i--;
				}
			}

			for (int j = i + 1; j < eList.size(); j++) {
				if (eList.get(j).type != Element.NUMBER) {
					break;
				}
				else {
					eList.set(i, new Element(eList.get(i).e + eList.get(j).e));
					eList.remove(j);
					j = i;
				}
			} // for(j)
		} // for(i)
	}

	public void calcBracket() {
		boolean inBracket = false;

		for (int i = 0; i < eList.size(); i++) {
			if (eList.get(i).type == Element.BRACKET_CLOSE) {
				inBracket = false;
				eList.remove(i);
				continue;
			}

			if (inBracket) {
				if (eList.get(i).type != Element.NUMBER) {
					eList.get(i).type += Element.SIGN_1;
				}
			}

			if (eList.get(i).type == Element.BRACKET_OPEN) {
				inBracket = true;
				eList.remove(i);
				i--;
				continue;
			}

		}
	}

	public void calcPrio() {
		for (int i = 1; i < eList.size(); i += 2) {
			if (eList.size() <= i + 2) {
				eList.set(i - 1, calc(eList.get(i - 1), eList.get(i + 1), eList.get(i)));
				eList.remove(i);
				eList.remove(i);
			} else if (eList.get(i).type >= eList.get(i + 2).type) {
				eList.set(i - 1, calc(eList.get(i - 1), eList.get(i + 1), eList.get(i)));
				eList.remove(i);
				eList.remove(i);
			} else {
				eList.set(i + 1, calc(eList.get(i + 1), eList.get(i + 3), eList.get(i + 2)));
				eList.remove(i + 2);
				eList.remove(i + 2);
			}
			i = -1;
		}
	}

	private Element calc(Element num1, Element num2, Element sign) {
		double n1 = Double.parseDouble(num1.e);
		double n2 = Double.parseDouble(num2.e);
		double result = 0;

		switch (sign.e) {
		case "+":
			result = (n1 + n2);
			break;
		case "-":
			result = (n1 - n2);
			break;
		case "*":
			result = (n1 * n2);
			break;
		case "/":
			result = (n1 / n2);
			break;
		case "%":
			result = (n1 % n2);
			break;
		case "^":
			result = (Math.pow(n1, n2));
			break;
		default:
			break;
		}

		Element r = new Element(String.valueOf(result));

		return r;
	}

}
