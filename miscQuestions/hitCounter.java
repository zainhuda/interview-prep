import java.sql.Time;
import java.util.ArrayDeque;
import java.util.Deque;

// follow up: how do u do ping constant time, accuracy of volume is nearest minute, 
// constnat means cant do more than 60 
public class HitCounter {
    class Hit {
        int hits;
        long time;
        public Hit(int hit) {
            this.hits = hit;
            this.time = System.currentTimeMillis();
        }
    }
    int count = 0;
    Deque<Hit> res = new ArrayDeque<>();
    public void ping(int val) {
        res.push(new Hit(val));
        count += val;
        if (res.getFirst.time-res.getLast().time > 60) {
            while (res.getFirst().time - res.getLast().time > 60) {
                Hit hit = res.removeLast();
                count -= hit.hits;
            }
        }
    }

    public int volume() {
        return count;
    }
}