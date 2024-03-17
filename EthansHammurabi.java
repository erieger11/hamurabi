package hammurabi; // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;

public class EthansHammurabi {         // must save in a file named Hammurabi.java
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    private static int bushels = 2000;
    private static int userBushelInput;
    private static int acres = 1000;
    private static int userAcresInput;
    private static int planting;
    private static int userPlantingInput;
    private static int years = 1;
    private static int totalCitizens = 100;
    private static int newCitizens;
    private static int ratsTotalConsumption;
    public static void main(String[] args) {
        while (true) {
            if (toPlay().equals("no")) {
                endTheGame();
                break;
            }
            rules();
            System.out.println(" ");
            if (readyToPlay().equals("no")) {
                endTheGame();
                break;
            }
            while(years < 11) {
                System.out.println("It's year : " + years);
                acresInput();
                feedingInput();
                plantingInput();


                newCitizens();
                ratsConsumption();
                //uprsing

                years++;
            }
            if(years == 11){
                theGameHasFinished();
            }
        }
    }

    public static String toPlay() {
        System.out.println("Do you want to play? Yes/No");
        return scanner.next().toLowerCase();
    }

    public static void rules(){
        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office. " +
                "\nYour duties are to dispense food, direct farming, and buy and sell land as needed to support your people. " +
                "\nWatch out for rat infestiations and the plague! Grain is the general currency, measured in bushels. " +
                "\nThe following will help you in your decisions:");
        System.out.println(" ");
        System.out.println(" - Each person needs at least 20 bushels of grain per year to survive");
        System.out.println(" - Each person can farm at most 10 acres of land");
        System.out.println(" - It takes 2 bushels of grain to farm an acre of land");
        System.out.println(" - The market price for land fluctuates yearly");
        System.out.println(" - Rule wisely and you will be showered with appreciation at the end of your term. Rule poorly and you will be kicked out of office!");
        System.out.println(" ");
    }


    //input methods
    public static String readyToPlay() {
        System.out.println("Are you ready to play? Yes/No");
        return scanner.next().toLowerCase();
    }

    public static void acresInput() {
        System.out.println("The city has a total of " + bushels + " bushels.");
        System.out.println("The city owns " + acres + " acres.");
        System.out.println(newCitizens + " new citizens came into the city.");
        System.out.println("There are a total of " + totalCitizens + " citizens.");
        System.out.println("The rats ate " + ratsTotalConsumption +" bushels");
        System.out.println(" ");
        System.out.println("How many acres would you like to buy or sell? (negative number to sell)");
        userAcresInput = scanner.nextInt();
    }
    public static void feedingInput(){
        System.out.println("How many bushels would you like to dispense to your citizens?");
        userBushelInput = scanner.nextInt();
    }
    public static void plantingInput(){
        System.out.println("How many bushels would you like plant? (2 bushels per acre)");
        userPlantingInput = scanner.nextInt();
        System.out.println(" ");
    }

    public static void newCitizens(){
        if(years>=1){
            newCitizens += random.nextInt(6);
        }
        totalCitizens += newCitizens;
    }
    public static void ratsConsumption(){
        if(years>=1) {
            ratsTotalConsumption = random.nextInt(101);
        }
        bushels -= ratsTotalConsumption;
    }


    //end game methods
    public static void theGameHasFinished(){
        System.out.println("Your term as leader has finished!");
        System.out.println("The city has a total of " + bushels + " bushels.");
        System.out.println("The city owns " + acres + " acres.");
        System.out.println("There are a total of " + totalCitizens + " citizens.");


    }

    public static void endTheGame () {
        System.out.println("Goodbye!");
    }
}



