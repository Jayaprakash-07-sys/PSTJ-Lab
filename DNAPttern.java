import java.util.*;

class DNAPttern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dna = sc.next();
        String pat = sc.next();

        int n = dna.length(), m = pat.length();
        int[] lps = new int[m];

        for (int i = 1, j = 0; i < m; ) {
            if (pat.charAt(i) == pat.charAt(j))
                lps[i++] = ++j;
            else if (j > 0)
                j = lps[j - 1];
            else
                i++;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && dna.charAt(i) != pat.charAt(j))
                j = lps[j - 1];

            if (dna.charAt(i) == pat.charAt(j))
                j++;

            if (j == m) {
                System.out.print((i - m + 1) + " ");
                j = lps[j - 1];
            }
        }
    }
}