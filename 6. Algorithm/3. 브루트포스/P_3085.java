package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* *
 * N * N 크기의 테이블에 사탕이 있다. (모든 가능성은 N^2)
 * 인접한 두 칸을 고르고, 사탕을 교환한다.
 * 그 다음, 같은 색으로 이루어져 있는 가장 긴 연속 부분 행 또는 열을 고르는 문제. (2가지를 찾기위해서는 O(N^2)
 * 
 * 즉, O(N^4)d이 걸린다.
 * 
 * */
public class P_3085 {

	public static void main(String[] args) throws Exception {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int arrSize = Integer.parseInt(br.readLine());
			String[][] arr = new String[arrSize][arrSize];
			String[] temp = null;
			
			for (int i = 0; i < arrSize; i++) {
				temp = br.readLine().split("");
				for (int j = 0; j < temp.length; j++) {
					arr[i][j] = temp[j];
				}
			}
			
			System.out.println(calculate(arr));
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static int calculate(String[][] arr) {
		int result = 0;
		int arrSize = arr[0].length - 1;
		
		/* 
		 * 사탕은 바꾸고 다시 원래자리로 돌려놔야 한다.
		 * */
		for (int i = 0; i <= arrSize; i++) {
			for (int j = 0; j <= arrSize; j++) {
				if (j + 1 <= arrSize) {
					swap(arr, i, j + 1, "v");
					int temp = check(arr);
					if (temp > result) result = temp;
					swap(arr, i, j + 1, "v");
				}
				
				if (i + 1 <= arrSize) {
					swap(arr, i + 1, j, "h");
					int temp = check(arr);
					if (temp > result) result = temp;
					swap(arr, i + 1, j, "h");
				}
			}
		}
		
		return result;
	}
	
	public static int check(String[][] arr) {
		int result = 0;
		int arrSize = arr.length - 1;
		
		for (int i = 0; i <= arrSize; i++) {
			int cnt = 1;
			for (int j = 1; j <= arrSize; j++) {
				if (arr[i][j].equals(arr[i][j - 1])) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				
				if (result < cnt) result = cnt;
			}
			
			cnt = 1;
			for (int j = 1; j <= arrSize; j++) {
				if (arr[j][i].equals(arr[j - 1][i])) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				
				if (result < cnt) result = cnt;
			}
		}
		
		return result;
	}
	
	// type = v(Vertical), h(Horizontal)
	public static void swap(String[][] arr, int a, int b, String type) {
		String temp = null;
		
		/*
		 * v 타입일 경우 현재 사탕을 우측 사탕이랑 바꾼다.
		 * h 타입일 경우 현재 사탕을 아래쪽 사탕이랑 바꾼다.
		 * */
		if (type.equals("v")) {
			temp = arr[a][b];
			arr[a][b] = arr[a][b - 1];
			arr[a][b - 1] = temp;
		} else if (type.equals("h")) {
			temp = arr[a][b];
			arr[a][b] = arr[a - 1][b];
			arr[a - 1][b] = temp;
		}
	}
	
}
