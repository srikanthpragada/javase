package mt;

public class PrimeTest {

	static class PrimeThread extends Thread {
		int num;

		public PrimeThread(int num) {
			this.num = num;
		}

		public void run() {
			for (int i = 2; i < num / 2; i++) {
				try {
					Thread.sleep(1);
				} catch (Exception ex) {

				}
				if (num % i == 0) {
					System.out.printf("%d is not prime\n", num);
					return;
				}
			} // for

			System.out.printf("%d is prime\n", num);
		}

	}

	public static void main(String[] args) {
		int a[] = { 292222929, 383833383, 383383831, 11212321, 33433333 };

		for (int n : a) {
			PrimeThread t = new PrimeThread(n);
			t.start();
		}

	}

}
