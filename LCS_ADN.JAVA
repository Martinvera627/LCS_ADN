public class LCS_ADN {
    // Método para encontrar la LCS usando DP
    public static String findLCS(String seq1, String seq2) {
        int m = seq1.length();
        int n = seq2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Llenado de la matriz DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Depuración: Imprimir la matriz DP
        System.out.println("Matriz DP:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // Reconstrucción de la LCS
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
                lcs.append(seq1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] == dp[i][j]) { // Cambio en la reconstrucción
                i--;
            } else {
                j--;
            }
        }
        
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String seq1 = "ACGTGCA";
        String seq2 = "GACTTAC";
        
        String lcs = findLCS(seq1, seq2);
        System.out.println("LCS de las secuencias es: " + lcs);
    }
}

