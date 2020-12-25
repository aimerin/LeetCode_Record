package Dynamic.q10_Regular_Expression_Matching;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = ss.length;
        int n = pp.length;

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pp[j - 1]== '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(ss, pp, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(ss, pp, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }

            }

        }
        return f[m][n];
    }

    public boolean matches(char[] s, char[] p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p[j - 1] == '.') {
            return true;
        }
        return s[i - 1] == p[j - 1];
    }
}
