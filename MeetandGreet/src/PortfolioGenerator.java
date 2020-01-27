import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PortfolioGenerator {
    private static PrintWriter out;
    private static File file = new File("output.txt");
    public static String name;
    public static String email;
    public static String background;
    public static String language;
    public static String achievement;
    public static ArrayList<String> languages = new ArrayList<>();
    public static ArrayList<String> achievements = new ArrayList<>();


    public static void main(String[] args) {
        getInfo();
        writeFile();
    }

    private static void getInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        name = input.nextLine();
        System.out.println("What is your email?");
        email = input.nextLine();
        System.out.println("Enter some personal background:");
        background = input.nextLine();
        System.out.println("Enter all programming lanugages that you know. Leave blank and hit ENTER when finished.");
        language = input.nextLine();
        do {
            languages.add(language);
            language = input.nextLine();
        }while(!language.equals(""));

        System.out.println("Enter all your achievements that you would like to share. Leave blank and hit ENTER when finished");
        achievement = input.nextLine();
        do{
            achievements.add(achievement);
            achievement = input.nextLine();
        }while(!achievement.equals(""));
    }
    
    private static void writeFile(){
        try {
            //write out the name of the user input
            out = new PrintWriter(file);
            for(int i = 0; i < 50; i++){
                out.print("*");
            }
            out.println(String.format("\n%s", name));
            for(int i = 0; i < 50; i++){
                out.print("*");
            }

            //Write out the email that the user has entered
            out.println(String.format("\n\nEmail: %s", email));

            //Write out the personal background from the user
            out.println(String.format("\n** Personal Background:"));
            for(int i = 0; i < 25; i++) {
                out.print("-");
            }
            out.println(String.format("\n%s", background));

            //Write out the list of languages from the list in a numerical order
            out.println(String.format("\n** Programming Languages:"));
            for(int i = 0; i < 25; i++) {
                out.print("-");
            }
            out.println();
            for(int i = 0; i < languages.size(); i++) {
                out.println(String.format("%s. %s", i + 1, languages.get(i)));
            }
            //Write out the different achievements that was entered by the user
            out.println(String.format("\n** Achievements and Things I would like to share:"));
            for(int i = 0; i < 25; i++) {
                out.print("-");
            }
            out.println();
            for(int i = 0; i < achievements.size(); i++) {
                out.println(String.format("%s. %s", i + 1, achievements.get(i)));
            }
            System.out.println();
            System.out.println();
            for(int i = 0; i < 50; i++){
                out.print("*");
            }
            //Closes the file
            out.close();
        }
        catch(Exception ex){
            System.out.println(String.format("Error: %s\n", ex));
        }
    }
}
