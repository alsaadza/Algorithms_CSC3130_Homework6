import java.util.*;

public class ElectionSystem {
    public static void main(String[] args) {

        int p = 5;
        Election election = new Election();
        LinkedList<String> candidates = new LinkedList<>(Arrays.asList("Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud"));

        System.out.println("Election Simulator");
        System.out.println("--------------------------------------------------------------");

        election.initializeCandidates(candidates, p);

        election.castVote("Cole Train");
        election.castVote("Cole Train");
        election.castVote("Marcus Fenix");
        election.castVote("Anya Stroud");
        election.castVote("Anya Stroud");


        System.out.println("Top 3 candidates after 5 votes: [" + election.getTopKCandidates(3) + "]");



        System.out.println();
        System.out.println("Rigging the election in favor of Marcus Felix....");
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