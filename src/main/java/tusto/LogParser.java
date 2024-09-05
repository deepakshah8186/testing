package tusto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser {

    public static void main(String[] args) {
        String logFilePath = "C:\\Users\\deepa\\Downloads\\FirstGitProject\\src\\main\\resources\\logfile.log"; // Replace with your log file path

        try (Stream<String> stream = Files.lines(Paths.get(logFilePath))) {
            Map<String, Long> requestCounts = stream
                    // .map(LogParser::getRequestType) // Extract the request type
                    .filter(requestType -> requestType != null) // Filter out nulls
                    //.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Count occurrences
                    .collect(Collectors.groupingBy(LogParser::getRequestType, Collectors.counting())); // Count occurrences

            // Print the results
            requestCounts.forEach((requestType, count) ->
                    System.out.println(requestType + ": " + count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to extract the request type (e.g., GET, POST) from a log line
    private static String getRequestType(String logLine) {
        String[] parts = logLine.split(" ");
        if (parts.length > 5) {
            return parts[5].replace("\"", ""); // Strip out quotes and return the HTTP method
        }
        return null; // Return null if the log line is not properly formatted
    }

    private static String getRequestTypeAgain(String logline){
        String[] values = logline.split(" ");
        for(int i=0;i<values.length;i++){
            String value = values[i];
            value.strip();
            return value.replace("\"","");

        }
        return null;
    }
}
