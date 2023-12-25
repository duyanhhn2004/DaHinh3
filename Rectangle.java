import java.awt.*;
import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, Color color, boolean filled, double velocityX, double velocityY) {
        super(color, filled, velocityX, velocityY);
        this.width = width;
        this.length = length;
    }


    public Rectangle(Point topLeft, double width, double length, Color color, boolean filled, double velocityX, double velocityY) {
        super(color, filled, velocityX, velocityY);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
    }

    public Point getTopLeft() {
        return topLeft;
    }

   
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

   
    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

 
    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

   
    @Override
    public String toString() {
        return "Rectangle[topLeft=" + topLeft.toString()
                + ",width=" + width
                + ",length=" + length
                + ",color=" + color
                + ",filled=" + filled + "]";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int) (topLeft.getPointX()), (int) (topLeft.getPointY()), (int) (width), (int) (length));
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        topLeft.setPointX(topLeft.getPointX() + getVelocity().getPointX());
        topLeft.setPointY(topLeft.getPointY() + getVelocity().getPointY());

        if (topLeft.getPointX() <= 0 || topLeft.getPointX() + width >= panelWidth) {
            getVelocity().setPointX(-getVelocity().getPointX());
        }
        if (topLeft.getPointY() <= 0 || topLeft.getPointY() + length >= panelHeight) {
            getVelocity().setPointY(-getVelocity().getPointY());
        }
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) <= 0.001
                && Double.compare(length, rectangle.length) <= 0.001
                && Objects.equals(topLeft, rectangle.topLeft);
    }


    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, length);
    }
}
