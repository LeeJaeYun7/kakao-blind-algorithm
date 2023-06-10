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
                        map[i][j] = '0';
                        cnt++; 
                    }
                }
            }
            
            if(cnt == 0){
                break;
            }else{
                answer += cnt; 
            }
            
           
            // 열을 0번째 열부터 n-1번째 열까지 순회한다. 
            for(int j=0; j<n; j++){
                
                // 행을 m-1행부터 0번째 행까지 순회한다. 
                for(int i=m-1; i>=0; i--){
                    
                    if(map[i][j] != '0'){
                        
                        int curRow = i; 
                        int targetRow = -1;
                        
                        while(true){
                            curRow++;
                            if(curRow >= m || map[curRow][j] != '0'){
                                break;
                            }
                            targetRow = curRow; 
                        }
                        
                        if(targetRow != -1){
                            char tmp = map[i][j];
                            map[i][j] = '0';
                            map[targetRow][j] = tmp;
                        }
                    }
                    
                }
                
            }

        }
        
        return answer;
    }
}
