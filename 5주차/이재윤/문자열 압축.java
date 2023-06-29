import java.util.*; 

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        int len = s.length();

        // 1부터 len길이까지 자른다 
        for(int i=1; i<=len; i++){
            
            String ans = "";
            
            ArrayList<String> strs = new ArrayList<>();
            int start = 0;
            int end = i;
            
            while(true){
                // start가 len보다 크거나 같으면 break한다
                if(start >= len){
                    break;
                }

                // end가 len보다 크다면, 
                // end를 len으로 지정한다 
                if(end > len){
                    end = len;
                }

                // tmp라는 자른 문자열을 만든다
                String tmp = s.substring(start, end);
                // strs 리스트에 문자열을 넣어준다 
                strs.add(tmp);

                // start와 end를 모두 i만큼 더해준다 
                start += i;
                end += i;                 
            }
            
            int cnt = 1;

            // strs에 있는 문자열들로, 
            // 문제에서 제시한 규칙에 맞는 압축된 문자열을 만든다 
            for(int j=1; j<strs.size(); j++){
                if(strs.get(j-1).equals(strs.get(j))){
                    cnt += 1;
                }else{
                    if(cnt != 1){
                        ans += Integer.toString(cnt);
                    }
                    ans += strs.get(j-1);
                    cnt = 1;
                }
            }
            
            if(cnt != 1){
                ans += Integer.toString(cnt);
            }
            ans += strs.get(strs.size()-1);
            
            // System.out.println(ans);
            // 압축된 문자열의 길이가 최소인 경우에 answer에 업데이트한다 
            answer = Math.min(answer, ans.length());
        }
        
        
        return answer;
    }
}
