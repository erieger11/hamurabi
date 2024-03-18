package hammurabi; // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;


//TODO .... if the input is greater than the amount owned
//TODO .... stats for ur game




public class EthansHammurabi {         // must save in a file named Hammurabi.java
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int years = 1;
    public static int userAcresInput;
    public static int userBushelInput;
    public static int userPlantingInput;
    public static int bushels = 2800;
    public static int acres = 1000;
    public static int totalCitizens = 100;
    public static int newCitizens;
    public static int ratsTotalConsumption;
    public static int peopleThatHaveStarvedToDeath;
    public static int costOfAcres = 19;
    public static int totalBushelsYield;
    public static int totalPeopleThatHaveDied;
    public static int totalPeopleThatCameYourCity = 100;
    public static int peopleDiedFromDisease;
    public static boolean youHaveBeenExiled;

    public static void main(String[] args) {
        playGame();
    }






    public static void playGame(){
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

                proceedingInputs();
                calculatingAcresCost();
                starvedToDeath();
                plantingFood();

                newCitizens();
                ratsConsumption();
                disease();
                uprising();
                years++;
            }
            if(years == 11){
                theGameHasFinished();
            }
        }
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





    //SCANNERS
    public static String toPlay() {
        System.out.println("Do you want to play? Yes/No");
        return scanner.next().toLowerCase();
    }
    public static String readyToPlay() {
        System.out.println("Are you ready to play? Yes/No");
        return scanner.next().toLowerCase();
    }
    public static void acresInput() {
        System.out.println("_________________________________________________________________________________________");
        System.out.println("The city has a total of " + bushels + " bushels. The acres produced " + totalBushelsYield + " bushels.");
        System.out.println(peopleThatHaveStarvedToDeath + " have starved to death.");
        System.out.println("The rats ate " + ratsTotalConsumption +" bushels. ");
        System.out.println("The city owns " + acres + " acres.");
        System.out.println("There are a total of " + totalCitizens + " citizens. " + newCitizens + " new citizens came into the city.");
        System.out.println("The cost of acres is " + costOfAcres + " bushels.");
        System.out.println("_________________________________________________________________________________________");

        System.out.println(" ");

        boolean isInputValid;
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("How many acres would you like to buy or sell? (negative number to sell)");
        userAcresInput = scanner.nextInt();
        isInputValid = validateAcresInput(userAcresInput);
        while(!isInputValid) {
            userAcresInput = scanner.nextInt();
            isInputValid = validateAcresInput(userAcresInput);
        }
    }
    public static boolean validateAcresInput(int input){
        if(input * costOfAcres > bushels){
            System.out.println("You don't have enough bushels? Enter a valid amount.");
            return false;
        }
        return true;
    }




    public static void feedingInput(){
        boolean isInputValid;
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("How many bushels would you like to dispense to your citizens?");
        userBushelInput = scanner.nextInt();
        isInputValid = validateBushelInput(userBushelInput);
        while(!isInputValid) {
            userBushelInput = scanner.nextInt();
            isInputValid = validateBushelInput(userBushelInput);
        }
    }
    public static boolean validateBushelInput(int input){
        if(input > bushels){
            System.out.println("You don't have enough bushels? Enter a valid amount.");
            return false;
        }
        return true;
    }





    public static void plantingInput(){
        boolean isInputValid;
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("How many acres would you like to plant? Remember it's 2 bushels per acre!");
        userPlantingInput = scanner.nextInt();
        isInputValid = validatePlantingInput(userPlantingInput);
        while(!isInputValid) {
            userPlantingInput = scanner.nextInt();
            isInputValid = validatePlantingInput(userPlantingInput);
        }
    }
    public static boolean validatePlantingInput(int input){
        if(input * 2 > bushels){
            System.out.println("You don't have enough bushels? Enter a valid amount.");
            return false;
        }
        return true;
    }




    public static void proceedingInputs(){
        acres += userAcresInput;
        bushels -= userBushelInput;
        bushels -= userPlantingInput * 2;
        totalPeopleThatHaveDied += peopleThatHaveStarvedToDeath + peopleDiedFromDisease;

    }

    public static void newCitizens() {
            if (peopleThatHaveStarvedToDeath <= 10) {
                newCitizens = (20 * acres + bushels) / (100 * totalCitizens) + 1;
            }
            totalCitizens += newCitizens;
        totalPeopleThatCameYourCity += newCitizens;
    }



    public static void calculatingAcresCost(){
        if (years >= 2 ) {
            costOfAcres = random.nextInt(24 - 17) + 17;
        }
            if(userAcresInput<0){
                bushels += costOfAcres * (userAcresInput * -1);
            }
            else {
                bushels -= userAcresInput * costOfAcres;
            }
    }

    public static void plantingFood() {
        int harvestYield = random.nextInt(6) + 1;
        totalBushelsYield = harvestYield * userPlantingInput;
        bushels += totalBushelsYield;
    }






    ///  BAD THINGS
    public static void starvedToDeath() {
        int foodTotalNeeded = totalCitizens * 20;
        int remainingFood = userBushelInput - foodTotalNeeded;

        if (remainingFood < 0) {
            int starvingPeople = (-remainingFood) / 20;
            peopleThatHaveStarvedToDeath = starvingPeople;
            totalCitizens -= starvingPeople;
        } else {
            peopleThatHaveStarvedToDeath = 0;
        }
    }

    public static void ratsConsumption() {
            int ratInvasion = random.nextInt(100)+1;
            if (ratInvasion < 41) {
                double ratsRandomConsumption = random.nextDouble()* 0.30;
                ratsTotalConsumption += (int) (bushels * ratsRandomConsumption);
            }
        bushels -= ratsTotalConsumption;
    }

    public static void disease() {
        int diseaseProbability = random.nextInt(100) + 1;
        if (diseaseProbability < 16) {
            peopleDiedFromDisease = totalCitizens / 2;
            totalCitizens -= peopleDiedFromDisease;
            System.out.println(" ");
            System.out.println("<> <> <> <> Oh no! A horrible disease has struck. You lost 50% of your population <> <> <> <>");
            System.out.println(" ");
        } else {
            peopleDiedFromDisease = 0;
        }
    }

    public static void uprising() {
        double uprisingLimit = totalCitizens * 0.45;
        if (peopleThatHaveStarvedToDeath >= uprisingLimit) {
            youHaveBeenExiled();
        }
    }







    //end game methods
    public static void theGameHasFinished(){
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Your term as leader has finished!");
        System.out.println("The city has a total of " + bushels + " bushels.");
        System.out.println("The city owns " + acres + " acres.");
        System.out.println("There ware a total of " + totalPeopleThatCameYourCity + " citizens that came to your city.");
        System.out.println("Sadly, you let " + totalPeopleThatHaveDied + " die.");
        System.out.println("_________________________________________________________________________________________");


    }
    public static void youHaveBeenExiled(){
        System.out.println("You let too many people starve to death! You are now exiled!");
        years = 11;
        endTheGame();
    }

    public static void endTheGame () {
        System.out.println("Goodbye!");
    }
}
//Ethan


