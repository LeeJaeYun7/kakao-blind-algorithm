class Solution {
    public int solution(String s) {
        int min = s.length();
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            min = Math.min(min, toCompactString(s, i).length());
        }
        return min;
    }

    String toCompactString(String s, int split){
        StringBuilder sb = new StringBuilder();
        String before = s.substring(0, split);
        int cnt = 1;
        int idx = 0;
        for (int i = split; i <= s.length() - split; i += split) {
            String now = s.substring(i, i + split);
            if(before.equals(now)) cnt++;
            else if(cnt == 1) sb.append(before);
            else{
                sb.append(cnt).append(before);
                cnt = 1;
            }
            before = now;
            idx = i + split;
        }

        if(cnt == 1) sb.append(before);
        else sb.append(cnt).append(before);

        sb.append(s.substring(idx)); // 자르는 단위보다 적은 개수의 문자열 남았을 때 더해주기

        return sb.toString();
    }


}
