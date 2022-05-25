package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 루트 N을 기준으로 양옆으로 곱해주면 구하고자 하는 약수가 나오게 된다.
// 예를들어 24의 약수를 구하게 된다면
// 1, 2, 3, 4, 6, 8, 12, 24
// 2와 12를 곱하면 24, 3과 8을 곱하면 24가 나오게 된다.
// 즉 진짜 약수를 구하고자 한다면 주어진 값의 최소값과 최대값을 곱해주면 된다.
public class P_1037 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int loop = Integer.parseInt(br.readLine());
			int[] array = new int[loop];
			
			String[] values = br.readLine().split(" ");
			
			for (int i = 0; i < values.length; i++) {
				array[i] = Integer.parseInt(values[i]);
			}
			
			int min = Integer.MAX_VALUE;
			int max = 0;
			
			if (array.length == 1) {
				min = array[0];
				max = array[0];
			} else {
				for (int i = 0; i < loop; i++) {
					if (min > array[i]) {
						min = array[i];
					}
				}
				
				for (int i = 0; i < loop; i++) {
					if (max < array[i]) {
						max = array[i];
					}
				}
			}
			
			System.out.println(min * max);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
