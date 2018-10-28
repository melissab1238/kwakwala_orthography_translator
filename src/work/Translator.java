package work;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TODO: add license
//TODO: add to github (just use the command line to simplify things)
    //Q: does git through the command line automatically know which account I am using?
    //TODO: on that note, learn about branches (switching, pulling, pushing).
        //This is especially important because I have multiple projects going in diff repos and accounts
//TODO: go from Napa to Umista (backwards)
    //TODO: add toggleswitch(?) for which direction u want to translate to
//TODO: make more intelliJ specific comment tags like "TODO" --> "bug", "random"
//TODO BUG: saasa translates to s(schwa)(schwa)s(schwa) :(



public class Translator {
    private static ArrayList<CharacterEquivalence> equivalences = new ArrayList<>();

    //used for testing, consider deleting...?
    public static void main(String[] args) throws IOException {
        loadEquivalences("equivalencyKey.txt");

        boolean run = true;
        while(run) {
            Scanner s = new Scanner(System.in);
            System.out.println("What direction do you want to translate to?\n" +
                    "\t 1 NAPA --> Umista \n" +
                    "\t 2 Umista --> NAPA \n");
            String chosenDirection = s.next();
            System.out.println("Input string: ('q' to quit)");

            String inputString = s.next();
            if(inputString.equals("q")){
                run = false;
                break;
            }

            if (chosenDirection.equals("1")){
                chosenDirection = "Umista"; //could be the source of a bug :(
                System.out.println("Word in Umista is: " + translateWord(inputString, chosenDirection));


            } else {
                chosenDirection = "NAPA";
                System.out.println("Word in NAPA is: " + translateWord(inputString, chosenDirection));
            }
            System.out.println();


        }
    }

    public static String translateWord(String inputString, String goalLanguage) {
        String newString = inputString;
        for (int i = 0; i < newString.length(); i++) {
            for (int j = 0; j < equivalences.size(); j++) {
                if(goalLanguage.equals("Umista"))
                    if (newString.charAt(i) == equivalences.get(j).getNapa())
                        newString = switchChar(i, j, newString, goalLanguage);
            }
        }
        return newString;
    }
    //TODO: refactor the two switchchartomethods into 1.
    private static String switchChar(int wordIndex, int equivalenceIndex, String word, String goalLanguage) {
        String newPart = "";
        if (goalLanguage.equals("Umista")){
            newPart = "" + equivalences.get(equivalenceIndex).getUmista();
        } else if (goalLanguage.equals("NAPA")){
            newPart = "" + equivalences.get(equivalenceIndex).getNapa();
        }else
            System.out.println("error tear tear(in switch char)");

        return word.substring(0,wordIndex) + newPart + word.substring(wordIndex+1);
    }

    /*
    //*IMPORTANT*
    public static String translateWordToNAPA(String inputString){
        String newString = inputString;
        for (int i = 0; i < newString.length(); i++) {
            for (int j = 0; j < equivalences.size(); j++) {
                if (newString.charAt(i) == equivalences.get(j).getUmista())
                    newString = switchCharToNapa(i, j, newString);
                if (newString.charAt(i) == equivalences.get(j).getNapa())
                    newString = switchCharToUmista(i, j, newString);
            }
        }
        return newString;
    }*/

    //TODO: make javadoc (requires, modifies, effects), tests! exception errors!
    //IMPORTANT: helper method
    private static String switchCharToNapa(int wordIndex, int equivalenceIndex, String word) {
        return (word.substring(0,wordIndex)) + (equivalences.get(equivalenceIndex).getNapa()) +
                (word.substring(wordIndex+1));
    }



    //IMPORTANT:
    //Effects: reads from input file, prints to output file
    //TODO: rename method to something more descriptive
    public static void run() throws IOException {
        PrintWriter writer = new PrintWriter("outputFile.txt", "UTF-8"); //writes, this method should be invoked a new object is created

        List<String> lines = Files.readAllLines(Paths.get("inputFile.txt"));

        String inputString = "";
        for (int p = 0; p < lines.size(); p++) {
            inputString = lines.get(p);

           //TODO!!!!stopped here 204pm writer.println(translateWordToNAPA(inputString));
        }
        writer.close(); //do not delete!
        System.out.println("File is saved. ");
    }

    //IMPORTANT
    //Effects: reads input file and saves unicode characters to equivalences
    public static void loadEquivalences(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));

        for (String line : lines) {
            ArrayList<String> listString = splitOnSpace(line);
            CharacterEquivalence ce = new CharacterEquivalence(listString.get(0), listString.get(1));
            equivalences.add(ce);

        }
        System.out.println("Equivalencies are loaded.");
    }

    //IMPORTANT: helper method
    //TODO: EFFECTS: ___
    private static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }


}
