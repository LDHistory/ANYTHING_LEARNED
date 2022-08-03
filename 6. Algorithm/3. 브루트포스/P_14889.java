package bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* *
 * go(index, first, second)
 * 
 * - index번째 사람을 어떤 팀에 넣을지 결정해야 한디.
 * - 1번 팀과 2번 팀에 속한 사람이 각각 first, second에 들어있다.
 * 
 * 만약 정답을 찾은 경우 index == n
 * 두 경우 모두 호출 전에 first 또는 Second에 index를 넣고, 호출 후에 빼는 과정이 필요하다.
 * 
 * 해당과정은 전체를 조회하는 브루트포스 방법이므로 백트래킹을 통해 최적화가 가능.
 * */
public class P_14889 {

	public static void main(String[] args) throws Exception {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[][] score = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					score[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			System.out.println(go(0, n, score, new ArrayList<Integer>(), new ArrayList<Integer>()));
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static int go(int index, int n, int[][] score, List<Integer> first, List<Integer> second) {
		if (index == n) {
			if (first.size() != n / 2) return -1;
			if (second.size() != n / 2) return -1;
			
			int t1 = 0;
			int t2 = 0;
			
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < n / 2; j++) {
					if (i == j) continue;
					t1 += score[first.get(i)][first.get(j)];
					t2 += score[second.get(i)][second.get(j)];
				}
			}
			
			return Math.abs(t1 - t2);
		}
		
		// index 사람이 1번 팀에 들어갔을 경우에 대한 모든 경우의 수를 구한다.
		int ans = -1;
		first.add(index);
		int t1 = go(index + 1, n, score, first, second);
		if (ans == -1 || (t1 != -1 && ans > t1)) {
			ans = t1;
		}
		// index 사람이 1번 팀에 대한 모든 결과를 계산했으므로 팀에서 제외한다.
		first.remove(first.size() - 1);
		
		// index 사람이 2번 팀에 들어갔을 경우에 대한 모든 경우의 수를 구한다.
		second.add(index);
		int t2 = go(index + 1, n, score, first, second);
		if (ans == -1 || (t2 != -1 && ans > t2)) {
			ans = t2;
		}
		// index 사람이 2번 팀에 대한 모든 결과를 계산했으므로 팀에서 제외한다.
		second.remove(second.size() - 1);
		return ans;
	}
	
}
