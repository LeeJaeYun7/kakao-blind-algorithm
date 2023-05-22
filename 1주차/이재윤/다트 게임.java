// 왜 맞았는가?
// 1. Stack을 써서 해당 값들을 저장해 놓는다
// 2. 문제의 조건에 따라 특수 기호가 등장할 때, 맞는 계산을 Stack에서 pop을 하면서 해준다
// 3. 1제곱, 2제곱, 3제곱 값은 Math.pow로 처리해준다. 
// 4. 숫자들은 String에 연결해서 기록하면서, 처리한다. 

import java.util.*; 

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String numStr = "";
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0; i<dartResult.length(); i++){
            
            char c = dartResult.charAt(i);
            
            if('0'<= c && c<= '9'){
                numStr += Character.toString(c);
            }else if(c == 'S' || c == 'D' || c == 'T'){
                
                int num = Integer.parseInt(numStr);
                int tmp = 0;
                if(c == 'S'){
                    tmp = (int)Math.pow(num, 1);
                }else if(c == 'D'){
                    tmp = (int)Math.pow(num, 2);   
                }else if(c == 'T'){
                    tmp = (int)Math.pow(num, 3);
                }
                
                stk.push(tmp);
                numStr = "";
                
            }else if(c == '*'){
                
                if(stk.size() == 1){
                    int num = stk.pop();
                    stk.push(num*2);
                }else if(stk.size() >= 2){
                    int num1 = stk.pop();
                    int num2 = stk.pop();
                    stk.push(num2*2);
                    stk.push(num1*2);
                }
                
            }else if(c == '#'){
                int num = stk.pop();
                stk.push(num*-1);
            }    
        }
        
        
        while(!stk.isEmpty()){
            answer += stk.pop();
        }
        
        return answer;
    }
}
