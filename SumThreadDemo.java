public class SumThreadDemo {

	static class SumThread extends Thread {
		private int num;

		public SumThread(int num) {
			this.num = num;
		}

		public void run() {
			int sum = 0;

			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.printf("\nSum of numbers from 1 to %d is %d", num, sum);
		}
	}

	public static void main(String[] args) {
		int nums[] = { 29292, 3933, 1121, 2322, 34 };

		for (int n : nums) {
			SumThread t = new SumThread(n);
			t.start();
		}

	}

}
