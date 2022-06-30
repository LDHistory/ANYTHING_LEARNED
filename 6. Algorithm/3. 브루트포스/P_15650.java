package bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * P_15649문제의 오름차순이 되어야 한다.
 * */
public class P_15650 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] values = br.readLine().split(" ");
			int n = Integer.parseInt(values[0]);
			int m = Integer.parseInt(values[1]);
			
			boolean[] a = new boolean[n];
			int[] b = new int[m];
			
			calculate(0, 1, n, m, a, b);
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static void calculate(int index, int start, int n, int m, boolean[] a, int[] b) {
		if (index == m) {
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i]);
				if (i == b.length - 1) {
					System.out.println();
				} else {
					System.out.print(" ");
				}
			}
			
			return;
		}
		
		for (int i = start ; i <= n; i++) {
			if (a[i - 1]) continue;
			a[i - 1] = true;
			b[index] = i;
			calculate(index + 1, i + 1, n, m, a, b);
			a[i - 1] = false;
		}
	}
	
}
