public class findDuplicateTeam {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] team1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        String[] team2 = {"ByteForce", "CodeCrafters", "NullPointers"};

        System.out.println(findDuplicateTeam(team1));
        System.out.println(findDuplicateTeam(team2));
    }
}
