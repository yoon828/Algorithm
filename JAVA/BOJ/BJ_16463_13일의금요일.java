import java.io.*;

public class BJ_16463_13일의금요일 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] month = new int[N+1][13];
		month[2019][1] = 1; // 0-6  월 : 0
		int cnt=0;
		for (int i = 2019; i <= N; i++) {
			for (int j = 1; j <= 12; j++) {
				if(j==1||j==3||j==5||j==7||j==8||j==10) {
					month[i][j+1] = (month[i][j]+31)%7;   
				}else if(j==4||j==6||j==9||j==11)
					month[i][j+1] = (month[i][j]+30)%7;   
				else if(j==2) { //2월인경우 윤년 확인
					if(i%400 ==0 || (i%100!=0 && i%4 == 0)) //윤년인경우
						month[i][j+1] = (month[i][j]+29)%7;
					else
						month[i][j+1] = (month[i][j]+28)%7;
				}else if(j==12 && i+1 <= N) { //12월인 경우 다음년 1월로
					month[i+1][1] = (month[i][j]+31)%7;
				}
				
				if((month[i][j]+13)%7 == 5) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
