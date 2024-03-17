package hammurabi; // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;


//TODO .... Need to fix the cost of acres on the on the first year to 19
//TODO .... need to upadte the rats and harvesting after the first year
//TODO .... need to chage if the acres are 0 that u cant plant land and must buy land



public class EthansHammurabi {         // must save in a file named Hammurabi.java
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    private static int bushels = 2800;
    private static int userBushelInput;
    private static int acres = 1000;
    private static int userAcresInput;
    private static int planting;
    private static int userPlantingInput;
    private static int years = 1;
    private static int totalCitizens = 100;
    private static int newCitizens;
    private static int ratsTotalConsumption;
    private static int randomCost;
    private static int starvingPeople;
    private static int costOfAcres = 19;
    private static int totalBushelsYield;
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
                calculatingAcresCost();
                acresInput();
                feedingInput();
                plantingInput();
                starvedToDeath();
                plantingFood();
                calculatingAcresCost();
                proceedingInputs();
                disease();
                starvedToDeath();
                ratsConsumption();
                newCitizens();

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
        System.out.println("The city has a total of " + bushels + " bushels. The acres produced " + totalBushelsYield + " bushels.");
        System.out.println(starvingPeople + " have starved to death.");
        System.out.println("The rats ate " + ratsTotalConsumption +" bushels.");
        System.out.println("The city owns " + acres + " acres.");
        System.out.println("There are a total of " + totalCitizens + " citizens." + newCitizens + " new citizens came into the city.");
        System.out.println("The cost of acres is " + randomCost + " bushels.");
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
    public static void proceedingInputs(){
        acres += userAcresInput;
        bushels -= userBushelInput;
        bushels -= userPlantingInput;
    }
    public static void newCitizens(){
        if(years>=1){
            newCitizens += (20 * acres  + bushels) / (100 * totalCitizens) + 1;
        }
        totalCitizens += newCitizens;
    }
    public static void ratsConsumption() {
        if (years >= 1) {
            if (bushels > 400) {
                 ratsTotalConsumption += random.nextInt(201);
            }
        }
        bushels -= ratsTotalConsumption;
    }

    public static void starvedToDeath(){
        if(years>=1) {
            int foodTotalNeeded = totalCitizens * 20;
            int remainingFood =  foodTotalNeeded - userBushelInput;

            if( foodTotalNeeded == userBushelInput ){
                starvingPeople = 0;


            } else if(foodTotalNeeded > userBushelInput) {
                for (int i = remainingFood; i % 20 != 0; i++){
                    remainingFood++;
                }
                starvingPeople = remainingFood/20;

            }else {
                starvingPeople = 0;

            }
        }
    }

    public static void calculatingAcresCost(){
        if (years >=1 ) {
            randomCost = random.nextInt(24-17) + 17;
            costOfAcres = userAcresInput * randomCost;
            bushels -= costOfAcres;
        }
    }
    public static void plantingFood(){
        if(years >= 1){
            int harvestYield =  random.nextInt(6) + 1;
            totalBushelsYield = harvestYield * userPlantingInput;
            totalBushelsYield -= userPlantingInput * 2;
            bushels += totalBushelsYield;
        }
    }
    public static void disease(){
        int diseaseProbability = random.nextInt(100)+1;
        if(years>=1)
            if(diseaseProbability < 16){
            Math.round(totalCitizens /= 2);
        }
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



