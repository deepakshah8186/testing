package crossmint;

public class MegaverseChallengePhase2 {
    private static final String CANDIDATE_ID = "84c5079a-469e-467e-89c7-0f929b32c1c0";

    public static void main(String[] args) throws Exception {
        EntityManager entityManager = new EntityManager(CANDIDATE_ID);

        // Fetch the goal map
        String goalMap = entityManager.fetchGoalMap();
        System.out.println(goalMap);

        // Parse and place entities based on the map
        entityManager.parseAndPlaceEntities(goalMap);
    }
}

