import java.util.Arrays;

public class PalindSubstring {

    public static void main(String[] args) {
        String[] words = {
                "ELRMENMET",
                "BABCBAB",
                "AAAAAA",
                "CacaaC",
                "forgeegsskeepfor"
        };
        int maxValue = 1;
        for(int m = 0; m < words.length; m++) {
            int maxLenght = 0;
            String word = words[m];
            word.split("");
            char[] str = word.toCharArray();
            int len = str.length;
            int[][] dp = new int[len+10][len+10];
            for(int i=0; i<len; i++) {
                dp[i][i] = 1;
            }
            for(int i=0; i<len-1; i++) {
                if(str[i] == str[i+1]) {
                    dp[i][i+1] = 2;
                }else {
                    dp[i][i+1] = 1;
                }
            }
            for(int k=2; k<len; k++) {
                for(int i=0; i+k<len; i++) {
                    int j = i+k;
                    if(str[i] == str[j]) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
            maxValue = Math.max(maxValue, dp[0][len-1]);
        }
        System.out.println(maxValue);
    }

}
