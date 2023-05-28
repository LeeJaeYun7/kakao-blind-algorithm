import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> hm = new HashMap<>();
        Queue<Message> queue = new LinkedList<>();

        for (String s : record) {
            if(s.startsWith("Enter")){
                queue.add(new Message("Enter", s.split(" ")[1]));
                hm.put(s.split(" ")[1], s.split(" ")[2]);
            }else if(s.startsWith("Leave")){
                queue.add(new Message("Leave", s.split(" ")[1]));
            }else{ // change
                hm.put(s.split(" ")[1], s.split(" ")[2]);
            }
        }

        int num = queue.size();
        String[] answer = new String[num];

        for (int i = 0; i < num; i++) {
            Message message = queue.poll();
            if(message.code.equals("Enter")) {
                answer[i] = hm.get(message.id) + "님이 들어왔습니다.";
            }else{
                answer[i] = hm.get(message.id) + "님이 나갔습니다.";
            }
        }
        return answer;
    }


}

class Message{
        String code;
        String id;

        public Message(String code, String id) {
            this.code = code;
            this.id = id;
        }
    }
