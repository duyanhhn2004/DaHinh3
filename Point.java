import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;


    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }


    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

  
    public double distance(Point newPoint) {
        return Math.sqrt(Math.pow(newPoint.pointX - this.pointX, 2)
                + Math.pow(newPoint.pointY - this.pointY, 2));
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(pointX, point.pointX) <= 0.001
                && Double.compare(pointY, point.pointY) <= 0.001;
    }

  
    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    public String toString() {
        return "(" + pointX + "," + pointY + ")";
    }
}
