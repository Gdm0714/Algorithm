class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                char moved = (char) ((c - 'a' + n) % 26 + 'a');
                answer.append(moved);
            } else if (Character.isUpperCase(c)) {
                char moved = (char) ((c - 'A' + n) % 26 + 'A');
                answer.append(moved);
            } else {
                answer.append(c);
            }
        }

        return answer.toString();
    }
}