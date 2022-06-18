package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* * 
 * 일곱 난쟁이 문제.
 * 9명 중 일곱명을 고르는 문제다.
 * 이는 곧 2명을 제외하는 것과도 같다.
 * 
 * 따라서 7명을 굴하는 방법보다 2명을 찾는 방법이 효율적이다.
 * 난쟁이 2명을 고르는 경우의 수는 N * (N - 1)이기 떄문에 O(N^2)가 된다.
 * 나머지 난쟁이의 키의 합을 고르는 시간 복잡도는 O(N)이 되기 때문에 총 O(N*3)이 된다.
 * 
 *  그러나 여기서 난쟁이의 키는 변하지 않는다는 점이 있다.
 *  모든 난쟁이의 키를 sum이라 할때, 저장 후 2명을 제외할 난쟁이를 i, j라고 할 때
 *  일곱난쟁이는 sum - A[i] - A[j]가 된다. 즉 시간복잡도는 O(1)이 된다.
 *  따라서 N(O^3)이 아니고 O(N^2)가 된다.
 * */
public class P_2309 {

	public static void main(String[] args) throws Exception {
		int sum = 0;
		boolean find = false;
		
		List<Integer> man = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			for (int i = 0; i < 9; i++) {
				man.add(Integer.parseInt(br.readLine()));
				sum += man.get(i);
			}
			
			for (int i = 0; i < 9; i++) {
				for (int j = i + 1; j <= 8; j++) {
					if (sum - man.get(i) - man.get(j) == 100) {
						man.remove(j);
						find = true;
						break;
					}
				}
				
				if (find) {
					man.remove(i);
					break;
				}
			}
			
			Collections.sort(man);
			
			for (int i = 0 ; i < 7; i++) {
				System.out.println(man.get(i));
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
}
