package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * f(A) 를 구하는 시간은 O(A)[모두 나누는 방법]가 되거나
 * A를 루트를 기점으로 계산해서 구할경우 O(루트A)가 된다.
 * 
 * g(N)을 구하게 될 경우 위의 방법으로는 N * O(N) 또는 N * O(루트N)이 된다.
 * 문제는 N이 1,000,000이 될 수 있으며 시간제한은 0.5초이기 때문에
 * 위의 방법으로는 풀 수 없다.
 * 
 * 약수의 반대는 배수가 된다는 공식을 이용한다.
 * 예를 들어 3의 배수는 3, 6, 9, 12, 15 ...가 나온다.
 * 3의 배수는 모두 3을 약수로 갖는 수가 된다.
 * 5의 배수는 모두 5를 약수로 갖는 수가 된다.
 * 
 * N이하의 자연수 중에서 1을 약수[반대로는 1의 배수]로 갖는 수의 개수는 [N/1]개
 * N이하의 자연수 중에서 2를 약수[반대로는 2의 배수]로 갖는 수의 개수는 [N/2]개
 * ...
 * N이하의 자연수 중에서 i를 약수[반대로는 i의 배수]로 갖는 수의 개수는 [N/i]개
 * 
 * 즉 g(N)은 [N/1]*1 + [N/2]*2 + [N/3]*3 + ... + [N/N]*N가 된다.
 * 
 * 이렇게 될 경우 시간복잡도는 O(N)이 된다.
 * */
public class P_17427 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			long sum = 0;
			int loop = Integer.parseInt(br.readLine());
			
			for (int i = 1; i <= loop; i++) {
				sum += (loop / i) * i;
			}
			
			System.out.println(sum);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
