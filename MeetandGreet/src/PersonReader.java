
import java.io.File;
import java.util.Scanner;

public class PersonReader {
    private static Scanner reader;
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile(){
        try {
            reader = new Scanner(new File("people.csv"));
            String[] header = new String[4];
            header = reader.nextLine().split(",");
            System.out.println(String.format("%-12s%3s%7s%14s", "Firstname", "Lastname", "Age", "Email"));
            for(int i = 0; i < 50; i++){
                System.out.print("=");
            }
            System.out.println();
            while(reader.hasNextLine()){
                String[] person = new String[4];
                person = reader.nextLine().split(",");
                String firstname = person[0];
                String lastname = person[1];
                String age = person[2];
                String email = person[3];

                System.out.println(String.format("%-12s%-12s%-12s%-12s", firstname, lastname, age, email));
            }


        } catch (Exception ex) {
            System.out.print(String.format("Error: %s", ex));
        }
    }
}
