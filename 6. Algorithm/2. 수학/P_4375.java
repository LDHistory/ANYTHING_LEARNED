package baekjoon;

import java.util.Scanner;

/** 
 * 1
 * {@link https://www.acmicpc.net/problem/4375}
 * 
 * 2와 5로 나누어 떨어지지 않는 정수 N이 주어졌을 때, 1로만 이루어진 N의 배수를 찾는 문제
 * 1 <= N <= 10000
 * 정수 N을 1, 11, 111, 1111 ...을 나누어 가면서 나머지가 0인 것을 찾으면 된다.
 * 다만 1로 이루어진 수가 기하급수적으로 커질 수 있기 때문에 저장하는 자료형의 범위를 넘어갈 수 있다.
 * 수의 크기가 커지면 나누는데 걸리는 시간도 매우 오래 걸린다.
 * 
 * 11 = (1 * 10 + 1) % n
 * 111 = (11 * 10 + 1) % n -> 이 때 (((11 % n)) * ((10 + 1) % N)) % N 이랑 결과가 같기 때문에 앞에 숫자를 크게 늘릴 필요가 없다.
 * 1111 = (111 * 10 + 1) -> 이 때 (((111 % n)) * ((10 + 1) % N)) % N 이랑 결과가 같기 때문에 앞에 숫자를 크게 늘릴 필요가 없다.
 * 
 * 뒤에서는 앞에서 나온 결과값을 바탕으로 값을 유추할 수 있다.
 * 따라서 앞에서 미리 구한 값을 N을 나눠주면 동일한 나머지가 나오게 된다.
 * */
public class P_4375 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, temp = 1;
		int count = 1;
		
		while (sc.hasNext()) {
			n = sc.nextInt();
			System.out.println(calculate(n, temp, count));
		}
	}
	
	public static int calculate(int n, int temp, int count) {
		if (temp % n == 0) {
			return count;
		}
		
		temp = (temp * 10 + 1) % n;
		return calculate(n, temp, ++count);
	}
	
}
