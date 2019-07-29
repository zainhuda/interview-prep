import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Asked by Uber
// On election day, voting machine writes in the form
// (voter_id, candidate_id)
// to a textfile. Write a program that reads this
// file as stream and returns the top  3 candidates
// at any given time. If you find a vote voting more than
// once, report this as fraud

class Solution {
    // cannot remember syntax for reading in file
    // if fraud, vote does not count
    // store keeps candidates and their votes
    // how do we read a file as a stream? (right now done as maxim)
    public int[] getTopThree(String filename) {
        Scanner read = new Scanner(filename);
        HashMap<String, Integer> store = new HashMap<>();
        Set<String> voterStore = new HashSet<>();
        while (read.hasNext()) {
            String[] vote = read.nextLine();
            if (!voterStore.contains(vote[0])) {
                store.add(vote[1], store.contains(vote[1]) ? store.get(vote[1]) + 1 : 1);
                voterStore.add(vote[0]);
            }
        }
        // can use a deque
        Deque<Integer> queue = new Deque<>();
        for (String key : store.keySet()) {
            queue.add(store.get(key));
        }
        int one = queue.pop();
        int two = queue.pop();
        int three = queue.pop();
        return int[one, two, three];
    }

}