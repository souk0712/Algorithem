import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                list.add(i);
            }
        }
        
        if(list.size() >= K){
            System.out.println(list.get(K-1));
        }else{
            System.out.println(0);
        }
    }
}