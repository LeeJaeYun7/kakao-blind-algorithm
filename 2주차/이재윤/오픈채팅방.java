import java.util.*; 


class Pair{
    String id;
    String action;
    
    public Pair(String id, String action){
        this.id = id;
        this.action = action; 
    }
}

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Pair> arr = new ArrayList<>(); 
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] info = record[i].split(" ");
            if(info.length == 3){
                String id = info[1];
                String name = info[2];
                map.put(id, name);
            }
        }
        
        
        for(int i=0; i<record.length; i++){
            String[] info = record[i].split(" ");
            if(info[0].equals("Enter")){
                arr.add(new Pair(info[1], info[0]));
            }else if(info[0].equals("Leave")){
                arr.add(new Pair(info[1], info[0]));
            }
        }
        
        for(int i=0; i<arr.size(); i++){
            Pair curr = arr.get(i);
            
            if(curr.action.equals("Enter")){
                String name = map.get(curr.id);
                answer.add(name +"님이 들어왔습니다.");
            }else if(curr.action.equals("Leave")){
                String name = map.get(curr.id);
                answer.add(name +"님이 나갔습니다.");
            }
        }
        
        
        return answer;
    }
}
