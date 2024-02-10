abstract class Shape{
    protected String name;
    protected String color;
    Shape(){
        this.name = "";
        this.color = "";
    }
    abstract double calculateArea();
    //    getter and setter for Shape's attributes
    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }

    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Color: " + this.color);
        System.out.println("Area: " + this.calculateArea());
    }
}

class Circle extends Shape{
    private double radius;
    Circle(){
        super();
        this.radius = 0;
    }
    //getters and setters for Circle's attributes
    public void setRadius(double radius){
        this.radius = radius;
    }

    @Override
    double calculateArea(){
        return Math.PI * this.radius * this.radius;
    }
}

interface Resizeable{
    void resize(double x);
}

class Rectangle extends Shape implements Resizeable{
    private double length;
    private double width;
    Rectangle(){
        super();
        this.length = 0;
        this.width = 0;
    }
    //setters for Rectangle's attributes
    public void setLength(double length){
        this.length = length;
    }

    public void setWidth(double width){
        this.width = width;
    }

    @Override
    double calculateArea(){
        return this.length * this.width;
    }

    public void resize(double x){
        this.length *= x;
        this.width *= x;
    }
}

public class AbstractClass{
    public static void main(String[] args){
        Circle circle = new Circle();
        circle.setName("Circle");
        circle.setColor("Red");
        circle.setRadius(5);
        circle.display();

        Rectangle rectangle = new Rectangle();
        rectangle.setName("Rectangle");
        rectangle.setColor("Blue");
        rectangle.setLength(5);
        rectangle.setWidth(3);
        rectangle.display();
        System.out.println("Resizing rectangle by 2 times:");
        rectangle.resize(2);
        rectangle.display();
    }
}


