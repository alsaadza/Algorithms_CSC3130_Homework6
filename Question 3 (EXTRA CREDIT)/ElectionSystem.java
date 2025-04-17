import java.util.*;

public class ElectionSystem {
    public static void main(String[] args) {
        Random random = new Random();

        List<String> allCandidates = Arrays.asList(
                "Esteban Parra Rodriguez", "Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud",
                "Kate Diaz", "Delmont Walker", "JD Fenix", "Baird", "Sam Byrne"
        );


        int numCandidates = random.nextInt(3, 8);
        LinkedList<String> candidates = new LinkedList<>();


        while (candidates.size() < numCandidates) {

            String candidate = allCandidates.get(random.nextInt(allCandidates.size()));
            if (!candidates.contains(candidate)) {
                candidates.add(candidate);
            }
        }

        int electorateSize = random.nextInt(10, 20);

        Election election = new Election();

        System.out.println("Election Simulator (EXTRA CREDIT)");
        System.out.println("--------------------------------------------------------------");

        System.out.println("Candidates: " + candidates);
        System.out.println("Number of electorate members: " + electorateSize);

        election.initializeCandidates(candidates, electorateSize);


        for (int i = 0; i < electorateSize; i++) {

            String randomVote = candidates.get(random.nextInt(candidates.size()));

            election.castVote(randomVote);
        }

        System.out.println("Top 3 candidates after " + electorateSize + " votes: [" + election.getTopKCandidates(3) + "]");

        System.out.println();
        System.out.println("Rigging the election in favor of Marcus Fenix....");
        election.rigElection("Marcus Fenix");
        System.out.println();

        System.out.println("Top 3 candidates after rigging the election: [" + election.getTopKCandidates(3) + "]");

        election.auditElection();

        System.out.println();
        System.out.println("Casting a random vote....");
        election.castRandomVote();
        election.auditElection();
        System.out.println();

    }
}
