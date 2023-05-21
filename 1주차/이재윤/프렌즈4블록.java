class Solution {
    
    public static char[][] map;
    public static boolean[][] check; 
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        map = new char[m][n];
        
        for(int i=0; i<m; i++){
            String str = board[i];
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println(); 
            }
            System.out.println(); 
        
        
        while(true){
            
            int cnt = 0; 
            check = new boolean[m][n];
            
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    char c = map[i][j];
                    if(c == '0'){
                        continue;
                    }
                    if(c == map[i][j+1] && c == map[i+1][j] && c == map[i+1][j+1]){
                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j] = true;
                        check[i+1][j+1] = true;
                    }   
                }
            }
            
            
            
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(check[i][j] == true){
                        cnt++; 
                    }
                }
            }
            
            if(cnt == 0){
                break;
            }else{
                answer += cnt; 
            }
            
            for(int j=0; j<n; j++){
                int bottom = -1;
                int top = -1; 
                
                for(int i=m-1; i>=0; i--){
                    if(check[i][j] == false){
                        if(bottom == -1 && top == -1){
                            continue;
                        }else{
                            break;   
                        }
                    }else{
                        map[i][j] = '0';
                        if(bottom == -1){
                            bottom = i;
                            top = i; 
                        }else{
                            top = i; 
                        }
                        
                    }
                }
                
                for(int i=top-1; i>=0; i--){
                    map[bottom][j] = map[i][j];
                    map[i][j] = '0';
                    bottom--;
                }
            }
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println(); 
            }
            System.out.println(); 

        }
        
        return answer;
    }
}
