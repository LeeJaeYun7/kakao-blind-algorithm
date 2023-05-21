import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int ans = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if(queue.contains(city)){
                ans += 1;
                queue.remove(city);
                queue.add(city);
            }else{
                ans += 5;
                queue.add(city);
                if(queue.size() > cacheSize)
                    queue.poll();
            }
        }
        return ans;
    }
}
