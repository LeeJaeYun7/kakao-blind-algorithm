
class Solution {
    static  boolean[][][] frame;
    public int[][] solution(int n, int[][] build_frame) {
        frame = new boolean[n + 1][n + 1][2];
        int num = 0; // 건축물 개수
        for (int[] buildPlan : build_frame) {
            int x = buildPlan[0];
            int y = buildPlan[1];
            int type = buildPlan[2];
            int delete = buildPlan[3];

            if (delete == 0) { // 삭제
                frame[x][y][type] = false;
                if (!isValid(n)) frame[x][y][type] = true; // 유효하지 않으며 되돌리기
                else num--;
            } else { // 추가
                frame[x][y][type] = true;
                if (!isValid(n)) frame[x][y][type] = false; // 유효하지 않으며 되돌리기
                else num++;
            }
        }

        int[][] ans = new int[num][3];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (frame[i][j][0]) {
                    ans[idx][0] = i;
                    ans[idx][1] = j;
                    ans[idx][2] = 0;
                    idx++;
                }
                if (frame[i][j][1]) {
                    ans[idx][0] = i;
                    ans[idx][1] = j;
                    ans[idx][2] = 1;
                    idx++;
                }
            }
        }

        return ans;
    }


    boolean isValid(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                // 기둥
                if(frame[i][j][0]){
                    if(!(j == 0 ||
                        frame[i][j-1][0] ||
                        ((i != 0 && frame[i-1][j][1]) || (i!= n && frame[i][j][1]))))
                        return false;
                }
              // 보
                if(frame[i][j][1]){
                    if(!(i != 0 && i != n && frame[i+1][j][1] && frame[i-1][j][1] || // 양쪽에 보
                            (j != 0 && frame[i][j-1][0]) || (j != 0 && frame[i+1][j-1][0])
                    )) return false;
                }
            }
        }

        return true;
    }
  
}
