package mac;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class OnlyPractice {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Testing:");

        Gson gson = new Gson();

        FileReader fileReader = new FileReader("C:\\Users\\deepa\\Downloads\\TestProject\\TestProject\\src\\main\\resources\\photographers1_copy.json");
        DataObject dataObject = gson.fromJson(fileReader,DataObject.class);
        System.out.println("Testing json:");


    }
}
