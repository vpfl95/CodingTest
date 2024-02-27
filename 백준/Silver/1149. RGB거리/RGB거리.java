import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N+1][3];
		
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N+1][3];
		dp[1][0] = rgb[1][0];
		dp[1][1] = rgb[1][1];
		dp[1][2] = rgb[1][2];
		
		
		for(int i=1; i<N+1; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
			
		}
		

		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
		
		
	}

}