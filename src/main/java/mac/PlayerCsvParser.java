package mac;

import java.util.ArrayList;
import java.util.List;

public class PlayerCsvParser {

    // CSV file header
    private static final String[] FILE_HEADER_MAPPING = {"ID", "Name", "Age"};

    // CSV delimiter
    private static final String CSV_DELIMITER = ",";

    public static List<Player> loadPlayers(String fileName) {

        List<Player> players = new ArrayList<>();

//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//            fileReader.readLine();
//            String line;
//            while ((line = fileReader.readLine()) != null) {
//                String[] fields = line.split(CSV_DELIMITER);
//                Player player = new Player();//
//                players.add(player);
//            }
//        } catch (IOException | NumberFormatException e) {
//            throw new RuntimeException("Error reading CSV file: " + fileName, e);
//        }

        return players;
    }
}
