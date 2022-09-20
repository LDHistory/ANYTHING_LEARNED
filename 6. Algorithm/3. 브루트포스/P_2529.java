package bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 부등호 기호 <와 >가 나열된 수열 A가 존재
 * 기호의 아 뒤에 한 자리 숫자를 넣어서 모든 부등호 관계를 만족시켜야함.
 * 이 때, 선택된 수는 모두 달라야 한다.
 * k개의 부등호 관계를 모두 만족시키는 (k+1)개 자리의 정수 중에서 최대값과 최소값을 구하는 문제
 */
public class P_2529 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int k = Integer.parseInt(br.readLine());
			String[] compare = new String[k];
			List<String> ans = new ArrayList<>();
			boolean[] check = new boolean[10];
			
			compare = br.readLine().split(" ");
			
			List<String> result = go(0, compare, "", k, ans, check);
			Collections.sort(result);
			System.out.println(result.get(result.size() - 1));
			System.out.println(result.get(0));
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static boolean ok(String[] compare, String num, int n) {
		for (int i = 0; i < n; i++) {
			if (compare[i].equals("<")) {
				if (num.charAt(i) > num.charAt(i + 1)) return false;
			} else if (compare[i].equals(">")) {
				if (num.charAt(i) < num.charAt(i + 1)) return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 중간에 조건이 맞지 않을 경우 그 다음 작업은 처리하지 않도록 백트랙킹 처리
	 */
	private static boolean backTracking(char x , char y, String op) {
		if (op.equals("<")) {
			if (x > y) return false;
		} else if (op.equals(">")) {
			if (x < y) return false;
		}
		
		return true;
	}
	
	private static List<String> go(int index, String[] compare,  String num, int n, List<String> ans, boolean[] check) {
		if (index == n + 1) {
			if (ok(compare, num, n)) {
				ans.add(num);
			}
			
			return ans;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (check[i]) continue;
			if (index == 0 || backTracking(num.charAt(index - 1), (char)(i + '0'), compare[index - 1])) {
				check[i] = true;
				go(index + 1, compare, num + Integer.toString(i), n, ans, check);
				check[i] = false;
			}
		}
		
		return ans;
	}
	
}
