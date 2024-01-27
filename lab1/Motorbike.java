public class Motorbike {
    int speed; 
    String model;

    public Motorbike (String model) {
        this.model = model;
    }
    public void accelerate() {
        // add 1 km/hr
        speed++;
    }
    
    public void stop() {
        // set current speed to zero 
        speed = 0;
    }

    public void printSpeed() {
        // display the current speed of this car
        System.out.println("The current speed of " + model + " is " + speed + " mpH");
    }
    public static void main(String[] args) { 
        // create new Honda car
        Motorbike honda = new Motorbike("Honda"); 
        // create new Yahama car
        Motorbike Yahama = new Motorbike("Yahama");
        // print current speed of Honda 
        honda.printSpeed();
        // call the accelerate method twice on Honda 
        honda.accelerate();
        honda.accelerate();
        // call the accelerate method once on Yahama 
        Yahama.accelerate();
        // print current speed of Honda 
        honda.printSpeed();
        // print current speed of Yahama 
        Yahama.printSpeed();
        // now park the Honda car 
        honda.stop();
        // print current speed of Honda
        honda.printSpeed();
    }
}