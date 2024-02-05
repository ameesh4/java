class Vehicle{
    protected String manufacturer;
    protected String model;
    protected int year;

    Vehicle(){
        this.manufacturer = "";
        this.model = "";
        this.year = 0;
    }

    //    getter and setter for Vehicle's attributes
    public String getManufacturer(){
        return this.manufacturer;
    }
    public void setManufacturer(String make){
        this.manufacturer = make;
    }
    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        this.year = year;
    }

    public void start(){
        System.out.println("Vehicle is starting");
    }

    public void stop(){
        System.out.println("Vehicle is stopping");
    }

    public void display() {
        System.out.println("Manufacturer: " + this.manufacturer);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
    }
}

class Car extends Vehicle{
    private int numberOfDoors;
    private String color;
    Car(){
        super();
        this.numberOfDoors = 0;
        this.color = "";
    }
    //getters and setters for Car's attributes
    public int getNumberOfDoors(){
        return this.numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors){
        this.numberOfDoors = numberOfDoors;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void start(){
        System.out.println("Car is starting");
    }

    @Override
    public void stop(){
        System.out.println("Car is stopping");
    }

    public void drift(){
        System.out.println("Car is drifting");
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Number of doors: " + this.numberOfDoors);
        System.out.println("Color: " + this.color);
    }
}

class Motorcycle extends Vehicle{
    private boolean hasFairings = false;
    private int engineSize;
    Motorcycle(){
        super();
        this.engineSize = 0;
    }
    //getters and setters for Motorcycle's attributes

    public boolean getHasFairings(){
        return this.hasFairings;
    }
    public int getEngineSize(){
        return this.engineSize;
    }
    public void setEngineSize(int engineSize){
        this.engineSize = engineSize;
    }

    @Override
    public void start(){
        super.start();
        System.out.println("Motorcycle is starting");
    }

    @Override
    public void stop(){
        super.stop();
        System.out.println("Motorcycle is stopping");
    }

    public void wheelie(){
        System.out.println("Motorcycle is doing a wheelie");
    }

    public void hasFairings(){
        this.hasFairings = true;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Has Fairings: " + this.hasFairings);
        System.out.println("Engine Size: " + this.engineSize+" cc");
    }
}

public class Vehicles{
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        vehicle.setManufacturer("Toyota");
        vehicle.setModel("Corolla");
        vehicle.setYear(2015);
        vehicle.display();
        System.out.println("=====================================");
        Car car = new Car();
        car.setManufacturer("Honda");
        car.setModel("Civic");
        car.setYear(2018);
        car.setNumberOfDoors(4);
        car.setColor("Black");
        car.display();
        car.start();
        car.stop();
        car.drift();
        System.out.println("=====================================");
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setManufacturer("Yamaha");
        motorcycle.setModel("R1");
        motorcycle.setYear(2019);
        motorcycle.setEngineSize(1000);
        motorcycle.hasFairings();
        motorcycle.display();
        motorcycle.start();
        motorcycle.stop();
        motorcycle.wheelie();
    }
}