class Solution {
    static int m, n;
    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;
        int len = 2 * m + n -2;
        int[][] lockMap = new int[len][len];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lockMap[m + i - 1][m + j - 1] = lock[i][j];
            }
        }
      
        for (int r = 0; r < 4; r++) {
            for (int i = 0; i < n + m - 1; i++) {
                for (int j = 0; j < n + m - 1; j++) {
                   
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            lockMap[k + i][l + j] ^= key[k][l];
                        }
                    }
                    if(isUnlocked(lockMap)) return true;
                    // lockMap 배열 원상복구
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            lockMap[k + i][l + j] ^= key[k][l];
                        }
                    }

                }
            }
            key = rotate(key);
        }

        return false;
    }

    boolean isUnlocked(int[][] lockMap){
        for (int i = m - 1; i < m - 1 + n; i++) {
            for (int j = m - 1; j <  m - 1 + n; j++) {
                if(lockMap[i][j] == 0) return false;
            }
        }
        return true;
    }

    int[][] rotate(int[][] arr){
        int[][] rotated = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotated[i][j] = arr[m - 1 - j][i];
            }
        }
        return rotated;
    }

}
