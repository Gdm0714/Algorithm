class Solution
{
    public int solution(String s) {
        int max = 1;
        if (s.length() <= 1) return s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                max = 2;
            }
        }
        
        for(int i = 3; i <= s.length(); i++){
            for(int j = 0; j <= s.length() - i; j++){
                int len = i + j - 1;
                
                if(s.charAt(j) == s.charAt(len) && dp[j + 1][len - 1]){
                    dp[j][len] = true;
                    max = i;
                }
            }
        }

        return max;
    }
}