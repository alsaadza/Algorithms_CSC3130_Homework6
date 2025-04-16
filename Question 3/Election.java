import java.util.*;
public class Election {

    private int voteTotal;
    private LinkedList<String> candidates;
    private Map<String, Integer> candidates_map;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;


    public void initializeCandidates(LinkedList<String> candidatesList, int p) {

        voteTotal = p;
        candidates = candidatesList;
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        candidates_map = new HashMap<>();

        for (int i = 0; i < candidates.size(); i++) {
            String name = candidates.get(i);
            candidates_map.put(name, 0);
        }

        updateMaxHeap();

    }



    public void castVote(String candidate) {
        if (candidates_map.containsKey(candidate)) {
            int currentVotes = candidates_map.get(candidate);

            candidates_map.put(candidate, currentVotes + 1);
            updateMaxHeap();
        }
    }

    public void castRandomVote(){

        Random gen = new Random();
        String randomCandidate = candidates.get(gen.nextInt(candidates.size()));  // Select random candidate
        castVote(randomCandidate);

        updateMaxHeap();

    }

    public void rigElection(String candidate){

        List<String> keys = new ArrayList<>(candidates_map.keySet());

        for (int i = 0; i < keys.size(); i++) {
            candidates_map.put(keys.get(i), 0);
        }

        int riggedVotes = ( (voteTotal / 2) + 1);
        candidates_map.put(candidate, riggedVotes);

        int remainingVotes = voteTotal - riggedVotes;
        int votesGiven = 0;

        for (int i = 0; i < keys.size(); i++) {

            String losing_ccandidate = keys.get(i);

            if (!losing_ccandidate.equals(candidate) && votesGiven < remainingVotes) {
                candidates_map.put(losing_ccandidate, 1);
                votesGiven = votesGiven + 1;
            }

        }

        updateMaxHeap();
    }

    public List<String> getTopKCandidates(int k){
        List<String> topCandidates = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> tempHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        tempHeap.addAll(candidates_map.entrySet());

        for (int i = 0; i < k && !tempHeap.isEmpty(); i++) {
            topCandidates.add(tempHeap.poll().getKey());
        }
        return topCandidates;
    }

    public void auditElection(){
        PriorityQueue<Map.Entry<String, Integer>> tempHeap = new PriorityQueue<>(maxHeap);

        System.out.println("Auditing Election....");
        System.out.println("--------------------------------------------------------------");
        while (!tempHeap.isEmpty()) {
            Map.Entry<String, Integer> entry = tempHeap.poll();
            System.out.println(entry.getKey() + " has " + entry.getValue() + " votes.");
        }

        System.out.println("--------------------------------------------------------------");
    }

    public void updateMaxHeap() {
        maxHeap.clear();
        maxHeap.addAll(candidates_map.entrySet());
    }


}
