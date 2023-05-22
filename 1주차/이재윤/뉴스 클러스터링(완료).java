// 왜 맞았는가?
// 1. union과 intersection은 각각 ArrayList로 처리해준다.
// -> 여기서 주의할 점이 HashSet으로 처리하면 안된다. 왜냐하면 중복된 것도 다른 것으로 처리해야 하기 때문이다.
// 2. 하나의 ArrayList를 순회하면서, 다른 ArrayList에 있는지 찾고, 있으면 remove 시키고, intersection에 추가한다
// 3. double과 int의 처리는 잘해줬다. 

import java.util.*; 

class Solution {

    public HashSet<String> set1;
    public HashSet<String> set2;
    
    public boolean check(String s){
        if('a' <= s.charAt(0) && s.charAt(0) <= 'z' && 'a' <= s.charAt(1) && s.charAt(1) <= 'z'){
            return true;
        }else{
            return false; 
        }
    }
    
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>(); 
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>(); 
        
        
        for(int i=0; i<str1.length()-1; i++){
            String tmp = str1.substring(i, i+2).toLowerCase();
            if(check(tmp)){
                set1.add(tmp);
            }
        }
                
        
        for(int i=0; i<str2.length()-1; i++){
            String tmp = str2.substring(i, i+2).toLowerCase();
            if(check(tmp)){
                set2.add(tmp);
            }
        }

        
        for(String str: set1){
            if(set2.remove(str)){
                intersection.add(str);
            }
            union.add(str);
        }
        
        for(String str: set2){
            union.add(str); 
        }
        
        if(union.size() == 0){
            return 65536;
        }
        
        double rate = (double)(intersection.size()) / (double)(union.size());
        int jakard = (int)(65536*rate);
        
        return jakard;
    }
}
