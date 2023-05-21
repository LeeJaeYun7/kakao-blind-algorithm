import java.util.*; 

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        int common = 0; 
        
        for(int i=0; i<str1.length()-1; i++){
            String tmp = str1.substring(i, i+2).toLowerCase();
            if('a'<=tmp.charAt(0) && tmp.charAt(0)<='z' && 'a'<=tmp.charAt(1) && tmp.charAt(1) <= 'z'){
                arr1.add(tmp);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String tmp = str2.substring(i, i+2).toLowerCase();
            if('a'<=tmp.charAt(0) && tmp.charAt(0)<='z' && 'a'<=tmp.charAt(1) && tmp.charAt(1) <= 'z'){
                arr2.add(tmp);
            }
        }
        
        int lenA = arr1.size();
        int lenB = arr2.size();

        if(lenA <= lenB){
            for(int i=0; i<lenA; i++){
                for(int j=0; j<lenB; j++){
                    if(arr1.get(i).equals(arr2.get(j))){
                        common++;
                        break;
                    }    
                }
            }   
        }else{
            
            for(int i=0; i<lenB; i++){
                for(int j=0; j<lenA; j++){
                    if(arr2.get(i).equals(arr1.get(j))){
                        common++;
                        break;
                    }    
                }
            }   
        }
        

        
        
        if(lenA == 0 && lenB == 0){
            return 65536;
        }
        System.out.println("lenA, lenB, common" + lenA + " " + lenB + " " +common);
            
        return (int)(65536*((double)common/(double)(lenA+lenB-common)));
        
    
    }
}
