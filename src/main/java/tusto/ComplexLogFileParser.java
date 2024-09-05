package tusto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexLogFileParser {

    // Regular expression to parse the HTTP log entries
    private static final String LOG_PATTERN =
            "^(\\S+) (\\S+) (\\S+) \\[(.*?)\\] \"(\\S+) (\\S+) (\\S+)\" (\\d{3}) (\\d+)";

    public static void main(String[] args) {
        String filePath = "C:\\Users\\deepa\\Downloads\\FirstGitProject\\src\\main\\resources\\webserver.log"; // Update this path to your log file location
        int getCallCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            Pattern pattern = Pattern.compile(LOG_PATTERN);

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                if (matcher.matches()) {
                    String method = matcher.group(1);
                    String resource = matcher.group(6);
                    String protocol = matcher.group(7);
                    int statusCode = Integer.parseInt(matcher.group(8));
                    int responseSize = Integer.parseInt(matcher.group(9));

                    // Check if the method is GET
                    if ("GET".equals(method)) {
                        getCallCount++;
                    }

                    // Optionally, you can output parsed details
                    System.out.println("Method: " + method);
                    System.out.println("Resource: " + resource);
                    System.out.println("Protocol: " + protocol);
                    System.out.println("Status Code: " + statusCode);
                    System.out.println("Response Size: " + responseSize);
                    System.out.println("---------------------------");
                } else {
                    System.out.println("Unrecognized log format: " + line);
                }
            }

            // Output the total number of GET calls
            System.out.println("Total number of GET calls: " + getCallCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
