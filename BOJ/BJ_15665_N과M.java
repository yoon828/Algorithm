package D0308;

import java.io.*;
import java.util.*;

/*
 1. 중복 제거, 정렬
 2. 중복 순열 
 */
public class BJ_15665_N과M {
	static List<Integer> list;
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Set<Integer> set = new HashSet<>(); //중복을 제거하기 위한 set 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken())); //set에 저장
		}
		list = new ArrayList<>();
		for (Integer integer : set) {
			list.add(integer); //list로 옮기기
		}
		Collections.sort(list); //오름차순 정렬

		perm(0); // 중복 순열 시작
		System.out.println(sb);
	}

	private static void perm(int cnt) {

		if (cnt == M) {// 기저조건
			for (int i : arr) {
				sb.append(i+" ");
			}sb.append("\n");
			return;
		}
		for (int i = 0; i < list.size(); i++) { //중복순열 시작
			arr[cnt] = list.get(i);
			perm(cnt + 1);
		}
	}

}