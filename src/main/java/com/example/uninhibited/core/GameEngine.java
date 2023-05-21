package com.example.uninhibited.core;

import java.util.*;

public class GameEngine {
    private static Scanner scanner;
    private Person player;
    private ArrayList<Car> availableCars;
    private ArrayList<House> availableHouses;
    private Set<Job> availableJobs;
    public GameEngine() {
        System.out.println("Game is starting...");
        scanner = new Scanner(System.in);
        ArrayList<Car> listedCars = new ArrayList<Car>();
        Car car1 = new Car("BMW X5", 10000, 11, 74, 210, 200, "black", 210);
        Car car2 = new Car("Audi A6", 12000, 10, 70, 200, 190, "red", 200);
        Car car3 = new Car("Mercedes-Benz E-Class", 15000, 9, 65, 190, 180, "white", 190);
        Car car4 = new Car("Volkswagen Passat", 8000, 12, 80, 220, 210, "blue", 220);
        Car car5 = new Car("Toyota Corolla", 5000, 13, 85, 230, 220, "silver", 230);
        Car car6 = new Car("Honda Civic", 4000, 14, 90, 240, 230, "green", 240);
        Car car7 = new Car("Fiat 500", 3000, 15, 95, 250, 240, "yellow", 250);
        Car car8 = new Car("Renault Clio", 2000, 16, 100, 260, 250, "orange", 260);
        Car car9 = new Car("Ferrari 458 Italia", 200000, 5, 50, 150, 300, "red", 300);
        Car car10 = new Car("Lamborghini Aventador", 300000, 4, 45, 140, 290, "yellow", 290);
        Car car11 = new Car("Bugatti Veyron", 500000, 3, 40, 130, 280, "black", 280);
        Car car12 = new Car("Koenigsegg Agera R", 1000000, 2, 35, 120, 270, "white", 270);
        Car car13 = new Car("McLaren P1", 1500000, 1, 30, 110, 260, "blue", 260);
        Car car14 = new Car("Tesla Model S", 100000, 6, 55, 160, 310, "silver", 310);
        Car car15 = new Car("Nissan Leaf", 50000, 7, 60, 170, 320, "green", 320);
        Car car16 = new Car("Ford Focus", 6000, 12, 75, 215, 205, "red", 215);
        Car car17 = new Car("Opel Astra", 7000, 11, 70, 205, 195, "white", 205);
        Car car18 = new Car("Peugeot 308", 8000, 10, 65, 195, 185, "black", 195);
        Car car19 = new Car("Hyundai i30", 9000, 9, 60, 185, 175, "blue", 185);
        Car car20 = new Car("Mazda 3", 10000, 8, 55, 175, 165, "silver", 175);
        Car car21 = new Car("Skoda Octavia", 11000, 7, 50, 165, 155, "green", 165);
        Car car22 = new Car("Seat Leon", 12000, 6, 45, 155, 145, "yellow", 155);
        listedCars.add(car1);
        listedCars.add(car2);
        listedCars.add(car3);
        listedCars.add(car4);
        listedCars.add(car5);
        listedCars.add(car6);
        listedCars.add(car7);
        listedCars.add(car8);
        listedCars.add(car9);
        listedCars.add(car10);
        listedCars.add(car11);
        listedCars.add(car12);
        listedCars.add(car13);
        listedCars.add(car14);
        listedCars.add(car15);
        listedCars.add(car16);
        listedCars.add(car17);
        listedCars.add(car18);
        listedCars.add(car19);
        listedCars.add(car20);
        listedCars.add(car21);
        listedCars.add(car22);
        Collections.sort(listedCars);
        this.availableCars = listedCars;
        ArrayList<House> listedHouses = new ArrayList<House>();
        House house1 = new House("Villa", 100000, 11, 74, 210, 200, 3, 210);
        House house2 = new House("Mansion", 120000, 10, 70, 200, 190, 5, 200);
        House house3 = new House("Castle", 150000, 9, 65, 190, 180, 7, 190);
        House house4 = new House("Bungalow", 80000, 12, 80, 220, 210, 2, 220);
        House house5 = new House("Cottage", 50000, 13, 85, 230, 220, 1, 230);
        House house6 = new House("Apartment", 40000, 14, 90, 240, 230, 1, 240);
        House house7 = new House("Flat", 30000, 15, 95, 250, 240, 1, 250);
        listedHouses.add(house1);
        listedHouses.add(house2);
        listedHouses.add(house3);
        listedHouses.add(house4);
        listedHouses.add(house5);
        listedHouses.add(house6);
        listedHouses.add(house7);
        this.availableHouses = listedHouses;
        Set<Job> listedJobs = new HashSet<Job>();
        Job job1 = new Job("CEO", 100000, "Urzisoft", "Bachelor");
        Job job2 = new Job("Manager", 80000, "Urzisoft", "Bachelor");
        Job job3 = new Job("Programmer", 60000, "Urzisoft", "Bachelor");
        Job job4 = new Job("Intern", 40000, "Urzisoft", "Bachelor");
        listedJobs.add(job1);
        listedJobs.add(job2);
        listedJobs.add(job3);
        listedJobs.add(job4);
        this.availableJobs = listedJobs;
    }
    public void initiatePlayer(){
        System.out.println("Enter your name: ");
        String inputName = scanner.nextLine();
        System.out.println("Enter your gender: ");
        String inputGender = scanner.nextLine();
        System.out.println("Enter your birth country: ");
        String inputNationality = scanner.nextLine();
        Random random = new Random();
        int randomHealth = random.nextInt(101);
        int randomHappiness = random.nextInt(101);
        int randomIntelligence = random.nextInt(101);
        int randomLooks = random.nextInt(101);
        Stats stats = new Stats(randomHealth, randomHappiness, randomIntelligence, randomLooks);
        this.player = new Person(inputName, inputGender, inputNationality, stats);
        this.player.setMoney(500000000);
    }
    public void modifyStats(){
        Random random = new Random();
        int randomHealthModifier = random.nextInt(11) - 5;
        int randomHappinessModifier = random.nextInt(11) - 5;
        int randomIntelligenceModifier = random.nextInt(11) - 5;
        int randomLooksModifier = random.nextInt(11) - 5;

        this.player.getStats().setHealth(this.player.getStats().getHealth() + randomHealthModifier);
        this.player.getStats().setHappiness(this.player.getStats().getHappiness() + randomHappinessModifier);
        this.player.getStats().setIntelligence(this.player.getStats().getIntelligence() + randomIntelligenceModifier);
        this.player.getStats().setLooks(this.player.getStats().getLooks() + randomLooksModifier);

        if (this.player.getStats().getHealth() > 100){
            this.player.getStats().setHealth(100);
        }
        if (this.player.getStats().getHappiness() > 100){
            this.player.getStats().setHappiness(100);
        }
        if (this.player.getStats().getIntelligence() > 100){
            this.player.getStats().setIntelligence(100);
        }
        if (this.player.getStats().getLooks() > 100){
            this.player.getStats().setLooks(100);
        }
        if (this.player.getStats().getHealth() < 0){
            this.player.getStats().setHealth(0);
        }
        if (this.player.getStats().getHappiness() < 0){
            this.player.getStats().setHappiness(0);
        }
        if (this.player.getStats().getIntelligence() < 0){
            this.player.getStats().setIntelligence(0);
        }
        if (this.player.getStats().getLooks() < 0){
            this.player.getStats().setLooks(0);
        }

    }
    public void advanceAge(){
        this.player.setAge(this.player.getAge() + 1);
        for (Car car : this.player.getCars()){
            car.setAge(car.getAge() + 1);
        }
        for (House house : this.player.getHouses()){
            house.setAge(house.getAge() + 1);
        }
        for (Car car: this.availableCars){
            car.setAge(car.getAge() + 1);
        }
        for (House house: this.availableHouses){
            house.setAge(house.getAge() + 1);
        }
        modifyStats();
        //modifyMoney();
    }

    public void showAvailableCars(){
        int i = 0;
        for (Car car : this.availableCars){
            i++;
            System.out.println(i + ". " + car.getName() + " - " + car.getPrice() + "€" + " - " + car.getAge() + " years old" + " - " + car.getHealth() + "% health" + " - Monthly cost: " + car.getMonthlyCost() + "€" + " - " + car.getPower() + " horse power" + " - Color: " + car.getColor());
        }
    }
    public void showAvailableHouses(){
        int i = 0;
        for (House house : this.availableHouses){
            i++;
            System.out.println(i + ". " + house.getName() + " - " + house.getPrice() + "€" + " - " + house.getAge() + " years old" + " - " + house.getHealth() + "% health" + " - Monthly cost: " + house.getMonthlyCost() + "€" + " - " + house.getRooms() + " rooms");
        }
    }
    public void showStats(){
        System.out.println("------------------------------------------------");

        System.out.println("Health: " + this.player.getStats().getHealth());
        System.out.println("Happiness: " + this.player.getStats().getHappiness());
        System.out.println("Intelligence: " + this.player.getStats().getIntelligence());
        System.out.println("Looks: " + this.player.getStats().getLooks());

        System.out.println("------------------------------------------------");
    }
    public void showData(){
        System.out.println(this.player.getName() + ", " + this.player.getNationality());
        System.out.println("You are a " + this.player.getAge() + " years old " + this.player.getGender() + ".");
        System.out.println("Budget: " + "€" + this.player.getMoney());
        showStats();
    }
    public void showBuyCarMenu(){
        System.out.println("------------------------------------------------");
        System.out.println("Available cars:");

        showAvailableCars();

        System.out.println("Enter the number of the car you want to buy.");
        System.out.println("Enter 'back' to go back to the main menu.");
        String inputCommand = scanner.nextLine();
        if(inputCommand.equals("back")){
            return;
        }
        else {
            int inputNumber = Integer.parseInt(inputCommand);
            if(inputNumber > 0 && inputNumber <= availableCars.size()){
                Car car = availableCars.get(inputNumber - 1);
                if(this.player.getMoney() >= car.getPrice()){
                    this.player.setMoney(this.player.getMoney() - car.getPrice());
                    this.player.addCar(car);
                    this.availableCars.remove(car);
                    System.out.println("You have bought a " + car.getName() + " for " + car.getPrice() + "€.");
                }
                else {
                    System.out.println("You don't have enough money to buy this car.");
                }
            }
            else {
                System.out.println("Invalid input.");
            }
        }
    }
    public void showBuyHouseMenu(){
        System.out.println("------------------------------------------------");
        System.out.println("Available houses:");

        showAvailableHouses();

        System.out.println("Enter the number of the house you want to buy.");
        System.out.println("Enter 'back' to go back to the main menu.");
        String inputCommand = scanner.nextLine();
        if(inputCommand.equals("back")){
            return;
        }
        else {
            int inputNumber = Integer.parseInt(inputCommand);
            if(inputNumber > 0 && inputNumber <= availableHouses.size()){
                House house = availableHouses.get(inputNumber - 1);
                if(this.player.getMoney() >= house.getPrice()){
                    this.player.setMoney(this.player.getMoney() - house.getPrice());
                    this.player.addHouse(house);
                    this.availableHouses.remove(house);
                    System.out.println("You have bought a " + house.getName() + " for " + house.getPrice() + "€.");
                }
                else {
                    System.out.println("You don't have enough money to buy this house.");
                }
            }
            else {
                System.out.println("Invalid input.");
            }
        }
    }
    public void showProperties(){
        System.out.println("------------------------------------------------");
        System.out.println("Your properties:");
        System.out.println("------------------------------------------------");
        System.out.println("Cars: ");
        int i = 0;
        for (Car car : this.player.getCars()){
            i++;
            System.out.println(i + ". " + car.getName() + " - " + car.getPrice() + "€" + " - " + car.getAge() + " years old" + " - " + car.getHealth() + "% health" + " - Monthly cost: " + car.getMonthlyCost() + "€" + " - " + car.getPower() + " horse power" + " - Color: " + car.getColor());
        }
        System.out.println("------------------------------------------------");
        System.out.println("Houses: ");
        i = 0;
        for (House house : this.player.getHouses()){
            i++;
            System.out.println(i + ". " + house.getName() + " - " + house.getPrice() + "€" + " - " + house.getAge() + " years old" + " - " + house.getHealth() + "% health" + " - Monthly cost: " + house.getMonthlyCost() + "€" + " - " + house.getRooms() + " rooms");
        }
        System.out.println("------------------------------------------------");
        System.out.println("Enter 'back' to go back to the main menu.");
        String inputCommand = scanner.nextLine();
        if(inputCommand.equals("back")){
            return;
        }
        else {
            System.out.println("Invalid input.");
        }
    }
    public void showJobs(){
        System.out.println("------------------------------------------------");
        System.out.println("Available jobs:");
        System.out.println("------------------------------------------------");
        int i = 0;
        for (Job job : this.availableJobs){
            i++;
            System.out.println(i + ". " + job.getName() + " - " + job.getSalary() + "€");
        }
        System.out.println("------------------------------------------------");
        System.out.println("Enter 'back' to go back to the main menu.");
        String inputCommand = scanner.nextLine();
        if(inputCommand.equals("back")){
            return;
        }
        else {
            System.out.println("Invalid input.");
        }
    }
    public void gameFlow(){
        initiatePlayer();
        label:
        while(true){
            System.out.println("------------------------------------------------");
            showData();
            System.out.println("Enter 'advance' to advance to the next month.");
            System.out.println("Enter 'quit' to stop simulating the game.");
            System.out.println("Enter 'buycar' to view available cars.");
            System.out.println("Enter 'buyhouse' to view available houses.");
            System.out.println("Enter 'properties' to view your properties.");
            System.out.println("Enter 'jobs' to view available jobs.");
            System.out.println("------------------------------------------------");
            String inputCommand = scanner.nextLine();
            switch (inputCommand) {
                case "advance":
                    advanceAge();
                    break;
                case "quit":
                    System.out.println("Game is quitting...");
                    break label;
                case "buycar":
                    showBuyCarMenu();
                    break;
                case "buyhouse":
                    showBuyHouseMenu();
                    break;
                case "properties":
                    showProperties();
                    break;
                case "jobs":
                    showJobs();
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}

