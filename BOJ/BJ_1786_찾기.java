import java.io.*;
import java.util.*;

public class BJ_1786_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tLength = text.length;
		int pLength = pattern.length;
		
		int[] pi = new int[pLength];//부분 일치 테이블
		int j = 0; 
		for (int i = 1; i < pLength; i++) { //부분일치 테이블 만들기
			while( j > 0  && pattern[i] !=pattern[j] ) j = pi[j-1]; 
			//패턴이 다르면 j의 위치를 pi[j-1]로 이동
			//j-1로 이동을 해야하는데 pi를 사용해서 확인할 수 있는 j의 횟수를 줄여줌
			//pi를 활용해서 j-1 개의 패턴에서 최소 몇개의 글자가 중복되는지 알 수 있기 때문에 그 다음 위치부터 시작하면 됨
				
			if(pattern[i] ==pattern[j]) pi[i] = ++j;
			else pi[i] = 0; 
		}
		
		int cnt = 0; 
		j=0;
		List<Integer> list = new ArrayList<>();
		//문자열 비교
		for (int i = 0; i < tLength; i++) {
			while(j> 0 && text[i] != pattern[j]) j = pi[j-1];
			if(text[i] == pattern[j]) {
				if(j == pLength-1) {
					cnt++;
					list.add((i+1)-pLength+1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		for (Integer i : list) {
			System.out.print(i+" ");
		}
		
	}
}
