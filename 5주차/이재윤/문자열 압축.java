import java.util.*; 

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        int len = s.length();
        
        for(int i=1; i<=len; i++){
            
            String ans = "";
            
            ArrayList<String> strs = new ArrayList<>();
            int start = 0;
            int end = i;
            
            while(true){
                if(start >= len){
                    break;
                }
                if(end > len){
                    end = len;
                }
                String tmp = s.substring(start, end);
                strs.add(tmp);
                start += i;
                end += i;                 
            }
            
            int cnt = 1;
            
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
            answer = Math.min(answer, ans.length());
        }
        
        
        return answer;
    }
}
