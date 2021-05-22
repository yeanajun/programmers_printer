import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        Queue<Loc> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Loc(i, priorities[i]));
        }

        while(!queue.isEmpty()) {
            Loc J = queue.poll();
            int cnt = 0;
            for(Loc K : queue){
                if(J.prior<K.prior){
                    cnt++;
                }
            }
            if (cnt > 0) {
                queue.offer(J);
            } else if (location != J.loca) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}

class Loc {

    int loca;
    int prior;

    public Loc(int location, int prior) {
        this.loca = location;
        this.prior = prior;
    }

}