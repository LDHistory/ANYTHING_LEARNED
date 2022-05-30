package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * 최대공약수를 구할 땐 유클리트 호제법을 이용한다.
 * gcd(a, b) = gcd(b, r)이라고 할 때 r = a % b이고 r이 0이 될 때 b가 최대공약수가 된다.
 * 최소공배수는 gcd를 응용하여 다음과 같이 구할 수 있다.
 * lcm(a, b) = gcd * (a / gcd) * (b / gcd)
 * */
public class P_2609 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] inputs = br.readLine().split(" ");
			
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			int gcd, lcm = 0;
			
			gcd = gcd(a, b);
			lcm = gcd * (a / gcd) * (b / gcd);
			
			System.out.println(gcd);
			System.out.println(lcm);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
	
}
