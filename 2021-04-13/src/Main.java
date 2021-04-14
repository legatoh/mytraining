import java.sql.Time;
import java.util.Scanner;

public class Main {

	public static void printMenu() {
		System.out.println("<����>");
		System.out.print("���� �Է�(������=exit): ");
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
				System.out.printf("�ɸ��ð�: %.10f", sec);
			}
			
			System.out.println();
		}

	}


}
