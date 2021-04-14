import java.sql.Time;
import java.util.Scanner;

public class Main {

	public static void printMenu() {
		System.out.println("<계산기>");
		System.out.print("수식 입력(끝내기=exit): ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c;
		double startTime = 0;
		Scanner in = new Scanner(System.in);
		String input = "";

		boolean isStop = false;

		while (!isStop) {
			printMenu();
			input = in.next();
			startTime = System.currentTimeMillis();
			if (input.equals("exit")) {
				isStop = true;
			} else {
				c = new Calculator(input);
				double sec = (System.currentTimeMillis() - startTime) / 1000;
				System.out.printf("걸린시간: %.10f", sec);
			}
			
			System.out.println();
		}

	}


}
