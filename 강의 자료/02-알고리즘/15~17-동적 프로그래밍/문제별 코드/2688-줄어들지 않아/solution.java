import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int Q;
    static long[][] Dy;

    static void input() {
        Q = scan.nextInt();
    }

    static void preprocess() {
        Dy = new long[65][10];

        // 초기값 구하기
        for (int num = 0; num <= 9; num++) {
            Dy[1][num] = 1;
        }

        // 점화식을 토대로 Dy 배열 채우기
        for (int len = 2; len <= 64; len++) {
            for (int num = 0; num <= 9; num++) {
                // 길이가 len이고 num으로 끝나는 개수를 계산하자 == Dy[len][num] 을 계산하자.
                for (int prev = 0; prev <= num; prev++) {
                    Dy[len][num] += Dy[len - 1][prev];
                }
            }
        }
    }

    static void pro() {
        for (int rep = 1; rep <= Q; rep++) {
            int N = scan.nextInt();
            long ans = 0;
            for (int num = 0; num <= 9; num++) ans += Dy[N][num];
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        preprocess();
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}