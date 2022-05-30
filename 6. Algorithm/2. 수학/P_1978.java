package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_1978 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int loop = Integer.parseInt(br.readLine());
			String[] read = br.readLine().split(" ");
			int count = 0;
			
			for (int i = 0; i < loop; i++) {
				 if (isPrime(Integer.parseInt(read[i]))) {
					 count += 1;
				 }
			}
			
			System.out.println(count);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
