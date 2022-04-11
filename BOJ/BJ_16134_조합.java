import java.io.*;

public class BJ_16134_조합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = 1000000007;
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int R = Integer.parseInt(str[1]);
			System.out.println(nCr(N,R,P));
	}
	public static long nCr(int n, int r, int p) {
		if(r==0) return 1;
		long[] fac = new long[n+1];
		fac[0]=1;
		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i-1]*i % p;
		}
		return (fac[n] * pow(fac[r], p-2, p)%p * pow(fac[n-r], p-2, p)%p) % p;
	}
	
	public static long pow(long x, long y, long p) {
		long res = 1;
		x=x%p;
		while(y>0) {
			if(y%2==1) res = (res * x ) % p;
			y=y>>1;
			x=(x*x)%p;
		}
		return res;
	}
}
