package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * P. 13023
 * 
 * 총 N명의 친구 관계가 주여졌을 때 친구 관계가 존재하는지 구하는 문제.
 * 
 * A는 B와 친구
 * B는 C와 친구
 * C는 D와 친구
 * D는 E와 친구
 *
 */

class Edge {
	private int from;
	private int to;
	
	Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
	
}

public class P_13023 {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			// 인접 행렬
			boolean[][] a = new boolean[n][n];
			
			// 인접 리스트
			List<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n];
			
			// 간선 리스트
			List<Edge> edges = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				g[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");
				int from = Integer.parseInt(input[0]);
				int to = Integer.parseInt(input[1]);
				
				// 양방향 그래프 표현
				edges.add(new Edge(from, to));
				edges.add(new Edge(to, from));
				
				// from -> to, to -> from이 갈 수 있다는 것을 표현
				a[from][to] = a[to][from] = true;
				
				// 인접 리스트에 추가
				g[from].add(to);
				g[to].add(from);
			}
			
			// 양방향 그래프이기 때문에 간선의 개수는 2배
			m *= 2;
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					// A -> B
					int A = edges.get(i).getFrom();
					int B = edges.get(i).getTo();
					// C - > D
					int C = edges.get(j).getFrom();
					int D = edges.get(j).getTo();
					
					// A, B, C, D가 모두 다르다.
					if (A == B || A == C || A == D || B == C || B == D || C == D) {
						continue;
					}
					
					// B -> C
					if (!a[B][C]) continue;
					
					// D -> E (A, B, C, D가 아닌 새로운 E를 찾아야 한다.)
					for (int E : g[D]) {
						if (A == E || B == E || C == E || D == E) continue;
						
						System.out.println(1);
						System.exit(0);
					}
				}
			}
			
			System.out.println(0);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
