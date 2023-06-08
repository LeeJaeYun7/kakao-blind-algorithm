import java.util.*; 

class Pair{
    int start;
    int end;
    
    public Pair(int start, int end){
        this.start = start;
        this.end = end; 
    }
}

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        ArrayList<Pair> logs = new ArrayList<>(); 
    
        for(int i=0; i<lines.length; i++){
            String line = lines[i];
            
            String[] splits = line.split(" ");
            String time = splits[1];
            String span = splits[2];
            span = span.substring(0, span.length()-1);
            
            String[] times = time.split(":");
            int start = 0;
            int end = 0;
            int spanTime = 0;
            String[] spans;
            if(span.length() == 1){
                spans = new String[1];
                spans[0] = span;
            }else{
                spans = span.split("\\.");
            }
            
            
            for(int j=0; j<times.length; j++){
                if(j == 0){
                    int hour = Integer.parseInt(times[j]);
                    end += hour*3600000;
                }else if(j == 1){
                    int minute = Integer.parseInt(times[j]);
                    end += minute*60000;
                }else if(j == 2){
                    String[] seconds = times[j].split("\\.");
                    end += Integer.parseInt(seconds[0])*1000;
                    end += Integer.parseInt(seconds[1]);
                }
                
            }
            
            for(int j=0; j<spans.length; j++){
                if(j == 0){
                    spanTime += Integer.parseInt(spans[j])*1000;
                }else if(j == 1){
                    String tmp = spans[j];
                    if(tmp.length() == 1){
                        tmp += "00";
                    }else if(tmp.length() == 2){
                        tmp += '0';
                    }
                    spanTime += Integer.parseInt(tmp);
                }
            }
            
            start = end-spanTime+1;   
            logs.add(new Pair(start, end));
        }
        
        for(int i=0; i<logs.size(); i++){
            int end = logs.get(i).end;
            int a = end;
            int b = end+999;
            if(b >= 24*3600000){
                b = 24*3600000-1;
            }
            
            int cnt = 1; 
            
            for(int j=i+1; j<logs.size(); j++){
                if(i == j){
                    continue;
                }
                int lstart = logs.get(j).start;
                if(lstart<=b){
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
            

        }
        
        return answer;
    }
}
