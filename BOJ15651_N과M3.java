import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651_N과M3 {

	static int N, M;
	static int[] pick;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pick = new int[M];
		perm(0);
		System.out.println(sb);
	}

	public static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < pick.length; i++) {
				sb.append(pick[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			pick[cnt] = i;
			perm(cnt + 1);
		}
	}

}
