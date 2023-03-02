import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		String [] list = {"c=","c-","d-","lj","nj","s=","z=",};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		int cnt=0;
		for (int i = 0; i < str.length(); ) {
			if(i+2 < str.length() && str.substring(i, i+3).equals("dz=")) {
				cnt++;
				i += 3;
			}else {
				boolean flag=false;
				for (int j = 0; j < 7; j++) {
					if(i+1 < str.length() 
							&& str.substring(i,i+2).equals(list[j])) {
					cnt++;
					i+=2;
					flag =true;
					break; 
					}
				}
				if(!flag) {
					cnt++;
					i++;
				}
			}
		}
		System.out.println(cnt);
	}
}
