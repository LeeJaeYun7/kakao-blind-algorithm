class Solution {
    public int solution(String dartResult) {
        int[] result = new int[3];
        int turn = 0;
        int score = -1;
        for (char c : dartResult.toCharArray()) {
            if(c >= '0' && c <= '9'){
                if(score == -1)
                    score = c - '0';
                else
                    score = 10;
            }else if(c == 'S' || c == 'D' || c == 'T'){
                result[turn] = getBonus(score, c);
                score = -1; // score 초기화
                turn++;
            }else if(c == '*') {
                if (turn == 1) {
                    result[0] *= 2;
                } else {
                    result[turn - 1] *= 2;
                    result[turn - 2] *= 2;
                }
            }else if(c == '#'){
                result[turn - 1] *= -1;
            }
        }

        return result[0] + result[1] + result[2];
    }
    int getBonus(int score, char c){
        if(c == 'S'){
            return score;
        }else if(c == 'D')
            return  score * score;
        return score * score * score;
    }
}

