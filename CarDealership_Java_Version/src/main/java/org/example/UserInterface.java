package org.example;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {
        this.dealership = null;
    }

    public void getDealership(){
        System.out.println("""
                                         Howdy!
                    Pick a dealership! Careful! Don't pick the wrong one...
                
                                    CascadeAutoSales
                                          OR
                                      SummitMotors"""); //Loads Dealership
        Dealership dealership = DealershipFileManager.getDealership(scanner.nextLine());
        setDealership(dealership);
    }

    public void display() {
        while (true) { // loop indefinitely until user chooses to exit

        System.out.println("""
                \\______________________/
                  __/__|_________|__\\__
                /⭕⭕____________⭕⭕\\
                |_____/___________\\_____|
                \\💥💥__|_|_|__|_|__💥💥/
                
                       -Vroooom-
                
                Welcome welcome!!
                1. Add a vehicle.
                2. Display our stock!
                3. Check out our cars by their pricing!
                4. Display our cars by make & model!!
                5. Check them out by year!
                6. Or by color?
                7. Maybe you want ta see 'em by mileage?
                8. Look at 'em all by type!
                9. Remove a vehicle
                0. Buy or Lease vehicle
                99. Hey hey where you goin'!??! (Exit)
                
                What you lookin' for?""");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                processAddVehicleRequest();
                break;
            case 2:
                processGetAllVehiclesRequest();
                break;
            case 3:
                processGetByPriceRequest();
                break;
            case 4:
                processGetByMakeModelRequest();
                break;
            case 5:
                processGetByYearRequest();
                break;
            case 6:
                processGetByColorRequest();
                break;
            case 7:
                processGetByMileage();
                break;
            case 8:
                processGetByVehicleTypeRequest();
                break;
            case 9:
                processRemoveVehicleRequest();
                break;
            case 0:
                sellLeaseCar();
                break;
            case 99:
                System.out.println("\nSo Long SUCKER (Exiting)");
                return;
            default:
                System.out.println("\nMake some SENSE! (Invalid Choice)");
        }
        }
    }

    /**
     * Sets the current dealership.
     */
    //private void init() setting the dealership
    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public void processGetByPriceRequest() {
        System.out.println("How low you willin' to go?(Minimum Price):\n");
        double minPrice = scanner.nextDouble();
        System.out.println("Whats your max budget lookin' like?(Maximum Price):");
        double maxPrice = scanner.nextDouble();

        //retrieve vehicles by price range form the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice,maxPrice);

        //display the retrieved vehicles
        if(vehicles.isEmpty()) {
            System.out.println("Couldn't make any sense of your jibberish! Try again bucko(No vehicles found in the specified price range.)");
        }
        else {
            System.out.println("This is what I got that fits your description:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }

    }

    //Process Get By Make Model Request
    public void processGetByMakeModelRequest() {
        System.out.println("Enter make: ");
        String make = scanner.next();
        System.out.println("Enter model: ");
        String model = scanner.next();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("Nothin' found in that make & model.");
        }
        else {
            System.out.println("Vehicles for the specified make and model:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }

    }

    //Process Get By Year request
    public void processGetByYearRequest() {
        System.out.println("Enter Minimum Year: ");
        int minYear = scanner.nextInt();
        System.out.println("Enter Maximum Year: ");
        int maxYear = scanner.nextInt();

        //retrieve vehicles by year from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear,maxYear);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("Nothin' found for that year buddy.");
        } else {
            System.out.println("Vehicles for the specified Year: ");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }


    //Process Get By Color Request
    public void processGetByColorRequest() {
        System.out.println("Enter Color: ");
        String color = scanner.next();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("Nothin' in that color fella.");
        } else {
            System.out.println("Here's what I got in that color");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }

   //Process Get By Mileage
    public void processGetByMileage() {
        System.out.println("Enter Min Mileage: ");
        double minMileage = scanner.nextDouble();
        System.out.println("Enter Max Mileage: ");
        double maxMileage = scanner.nextDouble();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No can do. Nothing in that mileage.");
        } else {
            System.out.println("Vehicles for the specified mileage:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }

    // Process Get By Vehicle Type Request
    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter Type: ");
        String type = scanner.next();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("Nothin' in that type buddy. Try again.");
        } else {
            System.out.println("Vehicles for the specified Type: ");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }


    // Process All Vehicle Request
    public void processGetAllVehiclesRequest() {

        // Retrieve all vehicles from dealership inventory
        List<Vehicle> vehicles = dealership.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("WE'RE ALL OUT OF CARS! EVERYONE PANIC");
        } else {
            // Display all vehicles
            System.out.println("Dealership Inventory:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    public void processAddVehicleRequest() {
        System.out.println("Enter VIN:");
        String vin = scanner.next();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        System.out.println("Enter make:");
        String make = scanner.next();
        System.out.println("Enter model:");
        String model = scanner.next();
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.next();
        System.out.println("Enter color:");
        String color = scanner.next();
        System.out.println("Enter odometer reading:");
        int odometer = scanner.nextInt();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();

        // Create Vehicle object with user input
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        // Add vehicle to dealership inventory
        dealership.addVehicle(vehicle);


        //process to remove vehicle request
        System.out.println("Enter VIN of the vehicle to remove:");
        String vinToRemove = scanner.next();


    }

    public void processRemoveVehicleRequest(){
        System.out.println("Please enter VIN Number: ");
        String vinNumber = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getInventory();

        for (Vehicle vehicle : vehicles){
            if (vinNumber.equalsIgnoreCase(vehicle.getVin())){
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle with VIN " + vinNumber + " removed successfully.");
                break;
            }
        }
        System.out.println("Vehicle Removed");
    }

    public void sellLeaseCar() {
        System.out.println("Welcome to CarDealership! What would you like to do today?");
        System.out.println("\t1) Lease a shiny new ride");
        System.out.println("\t2) Buy your dream car");
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                leaseVehicle();
                break;
            case 2:
                sellVehicle();
                break;
            default:
                System.out.println("\nOops! That's not a valid choice. Please try again and make some SENSE!");
        }
    }

    public void sellVehicle() {
        scanner.nextLine(); // Consume newline

        System.out.println("Let's get you that dream car! First, we need some info.");
        System.out.println("Enter the vehicle's VIN (Very Important Number):");
        String VIN = scanner.nextLine();

        Vehicle vehicle = dealership.findVehicleByVIN(VIN);

        if (vehicle == null) {
            System.out.println("Hmm... We can't seem to find a car with that VIN. Did you type it correctly?");
            return;
        }

        System.out.println("Great choice! Now, let's get down to business.");
        System.out.println("Enter the contract date (YYYYMMDD):");
        String dateOfContract = scanner.nextLine();

        System.out.println("Enter the customer's name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter the customer's email (for sending car memes and important stuff):");
        String customerEmail = scanner.nextLine();

        System.out.println("Do you want to finance your new beauty? (yes/no):");
        String financeOption = scanner.nextLine();
        boolean booleanFinance = financeOption.equalsIgnoreCase("yes");

        SalesContract salesContract = new SalesContract(dateOfContract, customerName, customerEmail, vehicle, booleanFinance);

        ContractDataManager.saveContract(salesContract);
        System.out.println("Congratulations! Your sales contract has been saved successfully. Enjoy your new ride!");
        dealership.removeVehicle(vehicle);
    }

    public void leaseVehicle() {
        scanner.nextLine(); // Consume newline

        System.out.println("Leasing a car? Smart choice! Let's get started.");
        System.out.println("Enter the vehicle's VIN (Very Important Number):");
        String VIN = scanner.nextLine();

        Vehicle vehicle = dealership.findVehicleByVIN(VIN);

        if (vehicle == null) {
            System.out.println("Oops! We couldn't find a car with that VIN. Are you sure you typed it correctly?");
            return;
        }

        System.out.println("Awesome! Let's move on to the details.");
        System.out.println("Enter the contract date (YYYYMMDD):");
        String dateOfContract = scanner.nextLine();

        System.out.println("Enter the customer's name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter the customer's email (for sending lease details and fun stuff):");
        String customerEmail = scanner.nextLine();

        LeaseContract leaseContract = new LeaseContract(dateOfContract, customerName, customerEmail, vehicle);

        ContractDataManager.saveContract(leaseContract);
        System.out.println("Fantastic! Your lease contract has been saved successfully. Enjoy your new ride!");
        dealership.removeVehicle(vehicle);
    }
}