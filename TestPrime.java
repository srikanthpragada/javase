import java.util.Scanner;

class PrimeThread extends Thread {
	int num;

	public PrimeThread(int num) {
		this.num = num;
	}

	@Override
	public void run() {

		for (int i = 2; i <= num / 2; i++) {
			try {
				Thread.sleep(100);
			} catch (Exception ex) {

			}
			if (num % i == 0) {
				System.out.printf("\n%d is not a prime number\n", num);
				return;
			}
		}
		System.out.printf("\n%d is a prime number\n", num);
	}
}

public class TestPrime {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("Enter a number :");
			int num = s.nextInt();
			if (num == 0)
				break;
			PrimeThread pt = new PrimeThread(num);
			pt.start();
		
		}

	}

}





