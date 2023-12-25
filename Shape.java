import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected boolean filled;

    protected Point velocity;

    public Shape() {
    }

 
    public Shape(Color color, boolean filled, double velocityX, double velocityY) {
        this.color = color;
        this.filled = filled;
        this.velocity = new Point(velocityX, velocityY);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }


    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Point getVelocity() {
        return velocity;
    }

    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

   
    public String toString() {
        return "Shape[color=" + color + ",filled=" + filled + "]";
    }

    public abstract void draw(Graphics g);

    public abstract void move(int panelWidth, int panelHeight);
}
