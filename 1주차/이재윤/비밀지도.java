import java.util.*; 

class Solution {
    
    public static int[][] map1;
    public static int[][] map2;
    public static int[][] resMap; 
    
    public String getBit(int n, int len){
        
        String res = "";
        
        while(true){
            int a = n % 2;
            res += Integer.toString(a);
            if(res.length() == len){
                break; 
            }
            n /= 2;
        }
        
        StringBuilder sb = new StringBuilder(res);
        String reversed = sb.reverse().toString();
        return reversed;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        map1 = new int[n+1][n+1];
        map2 = new int[n+1][n+1];
        resMap = new int[n+1][n+1];
        
        for(int i=0; i<arr1.length; i++){
            int num = arr1[i];
            
            String res = getBit(num, n); 
            for(int j=0; j<n; j++){
                map1[i][j] = res.charAt(j)-'0';
            }
        }
        
        
        for(int i=0; i<arr2.length; i++){
            int num = arr2[i];
            
            String res = getBit(num, n); 
            
            for(int j=0; j<n; j++){
                map2[i][j] = res.charAt(j)-'0';
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map1[i][j] == 1 || map2[i][j] == 1){
                    resMap[i][j] = 1;
                }else{
                    resMap[i][j] = 0; 
                }
            }
        }
        
        for(int i=0; i<n; i++){
            String tmp = "";
            
            for(int j=0; j<n; j++){
                if(resMap[i][j] == 1){
                    tmp += "#";
                }else{
                    tmp += " ";
                }
            }
            answer[i] = tmp; 
        }
            
        return answer;
    }
}
