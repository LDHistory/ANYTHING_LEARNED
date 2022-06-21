package bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
**/
public class P_15649 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] values = br.readLine().split(" ");
			int n = Integer.parseInt(values[0]);
			int m = Integer.parseInt(values[1]);
			
			boolean[] a = new boolean[n];
			int[] b = new int[m];
			
			calculate(0, n, m, a, b);
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static void calculate(int index, int n, int m, boolean[] a, int[] b) {
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
		
		for (int i = 1; i <= n; i++) {
			if (a[i - 1]) continue;
			a[i - 1] = true;
			b[index] = i;
			calculate(index + 1, n, m, a, b);
			a[i - 1] = false;
		}
	}
	
}
