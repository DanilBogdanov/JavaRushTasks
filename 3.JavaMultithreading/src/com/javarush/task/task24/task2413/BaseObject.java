package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void setX(double x) {this.x = x;}

    public void setY(double y) {this.y = y;}

    public void setRadius(double radius) {this.radius = radius;}

    public double getX() {return x;}

    public double getY() {return y;}

    public double getRadius() {return radius;}

    abstract void draw(Canvas canvas);

    abstract void move();


    public boolean isIntersec(BaseObject o) {
        double sqrX = Math.pow(((Math.abs(o.getX() - this.getX()))), 2);
        double sqrY = Math.pow(((Math.abs(o.getY() - this.getY()))), 2);
        double length = Math.sqrt(sqrX + sqrY);

        return length <= Math.max(radius, o.radius);

    }

}
