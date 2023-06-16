import java.util.*; 

class Solution {
    
    public boolean isRight(String u){
        
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                stk.push('(');
            }else{
                if(stk.size() == 0){
                    return false;
                }
                stk.pop();
            }
        }
        
        if(stk.size() == 0){
            return true;
        }
        
        return false;
        
        
    }
    
    public String getNewU(String u){
        int uLen = u.length(); 
        String tmp = u.substring(1, uLen-1);
        String ans = "";
        
        for(Character c: tmp.toCharArray()){
            if(c == '('){
                ans += Character.toString(')');
            }else{
                ans += Character.toString('(');
            }
        }
        
        return ans; 
        
    }
    
    
    public String recursive(String p){
        
        if(p.equals("")){
            return "";
        }
        
        int open = 0;
        int close = 0;
        String u = "";
        String v = "";
        
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                open += 1;
            }else{
                close += 1;
            }
            
            if(open == close){
                u = p.substring(0, i+1);
                v = p.substring(i+1);
                
                boolean res = isRight(u);
            
                if(res){
                    return u + recursive(v);
                }else{
                    break;
                }
            }
            
            
        }
        
        
        String tmp = "";
        tmp += Character.toString('(');
        tmp += recursive(v);
        tmp += Character.toString(')');
        tmp += getNewU(u);
        return tmp; 
        
        
        
    }
    
    
    
    public String solution(String p) {
        String answer = "";
        
        if(p.equals("")){
            return answer;
        }
        
        answer = recursive(p);
        
        
        return answer;
    }
}
