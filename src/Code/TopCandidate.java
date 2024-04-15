package Code;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TopCandidate {

    /**
     * You are given two integer arrays persons and times. In an election, the ith vote was cast for persons[i] at time times[i].
     *
     * For each query at a time t, find the person that was leading the election at time t. Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.
     *
     * Implement the TopVotedCandidate class:
     *
     * TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
     * int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.
     *
     *
     * Example 1:
     *
     * Input
     * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
     * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
     * Output
     * [null, 0, 1, 1, 0, 0, 1]
     *
     * Explanation
     * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
     * topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
     * topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
     * topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
     * topVotedCandidate.q(15); // return 0
     * topVotedCandidate.q(24); // return 0
     * topVotedCandidate.q(8); // return 1
     *
     *
     *
     * Constraints:
     *
     * 1 <= persons.length <= 5000
     * times.length == persons.length
     * 0 <= persons[i] < persons.length
     * 0 <= times[i] <= 109
     * times is sorted in a strictly increasing order.
     * times[0] <= t <= 109
     * At most 104 calls will be made to q.
     *
     */

    public static void main(String[] args) {
        int[] persons = {0,0,0,0,1};
        int[] time = {0,6,39,52,75};
        /*int[] persons = {0,1,1,0,0,1,0};
        int[] time = {0,5,10,15,20,25,30};*/
        TopCandidate t = new TopCandidate(persons, time);
        System.out.println(t.q(99));
    }

    Map<Integer, Integer> voteBank = new TreeMap<>();
    int prev;
    int[] p = new int[5000];
    int maxTime = 0;
    int lastWinner;

    public TopCandidate(int[] persons, int[] times) {
        for(int x = 0; x < 5000; x++){
            p[x] = 0;
        }
        prev = persons[0];
        int winner = prev;
        for(int i = 0; i < times.length; i++){
            if(maxTime < times[i]){
                maxTime = times[i];
            }
            int vote = p[persons[i]] + 1;
            p[persons[i]] = vote;
            if(prev != persons[i]){
                int t = p[prev];
                if(t <= vote){
                    winner = persons[i];
                    prev = winner;
                }
            }
            voteBank.put(times[i], winner);
        }
        lastWinner = winner;
    }

    public int q(int t) {
        if(t > maxTime){
            return lastWinner;
        }
        int winner = -1;

        Map<String, String> m = new HashMap<>();
        for(int k : voteBank.keySet()){
            if(k > t){
                break;
            }
            winner = voteBank.get(k);
        }
        return winner;
    }
}
