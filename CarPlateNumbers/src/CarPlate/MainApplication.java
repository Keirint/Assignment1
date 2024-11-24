package CarPlate;

import java.util.Scanner;
//In the public class CarplateGenerator we do all the compiling ,create the userface and use all the methods created on CarPlate Class.
public class MainApplication {
    private CarplateManager carplate;

    public MainApplication() {
        this.carplate=new CarplateManager();
    }
    public String generateRandomPlate() {
        return carplate.generateCarPlate();
    }
    public String generateNextCarPlate(String currentPlate) {
        if(!carplate.isValidPlate(currentPlate)){
            throw new IllegalArgumentException("Invalid plate "+currentPlate);
        }
        return carplate.getNextCarPlate(currentPlate);
    }
    public static void main(String[] args) {
        MainApplication cg=new MainApplication();
        Scanner input=new Scanner(System.in);
        String  userchoice;

        do{
            System.out.println("CarPlate Generator ");
            System.out.println("1. Enter a Plate Manually ");
            System.out.println("2. Generate Car Plate ");
            System.out.println("X. Exit");
            System.out.println("Enter your choice: ");
            userchoice=input.nextLine().toUpperCase();


            switch (userchoice) {
                case "1":
                    System.out.println("Enter the car plate number: ");
                    String currentPlate=input.nextLine().toUpperCase();
                    try{
                        String nextCarPlate =cg.generateNextCarPlate(currentPlate);
                        System.out.println("Next Plate is"+ nextCarPlate);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    String randomPlate=cg.generateRandomPlate();
                    System.out.println("Random Car PLate : "+ randomPlate);
                    String nextPlate=cg.generateNextCarPlate(randomPlate);
                    System.out.println("Next Car Plate : "+ nextPlate);
                    break;
                case "X":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice.Please Try Again");

            }


        }  while (!userchoice.equals("X"));
        input.close();
    }


}
