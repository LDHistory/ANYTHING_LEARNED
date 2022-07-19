package bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 1, 2, 3 더하기
 * 
 * count : 사용한 수의 개수
 * sum : 합
 * 
 * 함수 호출을 할 경우 다음의 경우에 대해 호출을 진행.
 * 정답을 찾을 경우 탈출.
 * 만약 결과값에서 위배 될 경우 탈출을 해야한다.
 * */
public class P_9095 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] values = new int [n];
			
			for (int i = 0; i < n; i ++) {
				values[i] = Integer.parseInt(br.readLine());
			}
			
			for (int i = 0; i < values.length; i++) {
				System.out.println(count(0, 0, values[i]));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static int count(int count, int sum, int n) {
		if (sum == n) {
			return count + 1;
		}
		
		for (int i = 1; i <= 3; i++) {
			if (sum + 1 <= n) count = count(count + 1, sum + i, n);
		}
		
		return count;
	}
	
}
