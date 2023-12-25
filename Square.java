import java.awt.*;
import java.util.Objects;

public class Square extends Rectangle {
    public Square() {

    }

    /**
     * Ham khoi tao 1 tham so.
     *
     * @param side side
     */
    public Square(double side) {
        super(side, side);
    }

    /**
     * Ham khoi tao 3 tham so.
     *
     * @param side   side
     * @param color  mau
     * @param filled fill
     */
    public Square(double side, Color color, boolean filled, double velocityX, double velocityY) {
        super(side, side, color, filled, velocityX, velocityY);
    }

    /**
     * ham khoi tao 5 tham so.
     *
     * @param topLeft top
     * @param side    canh
     * @param color   mau
     * @param filled  fill
     */
    public Square(Point topLeft, double side, Color color, boolean filled, double velocityX, double velocityY) {
        super(topLeft, side, side, color, filled, velocityX, velocityY);
    }

    public double getSide() {
        return width;
    }

    /**
     * Ham side.
     *
     * @param side side
     */
    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Ham width.
     *
     * @param side rong
     */
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Ham length.
     *
     * @param side dai
     */
    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    /**
     * Ham in.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Square[topLeft=" + topLeft.toString()
                + ",side=" + width
                + ",color=" + color
                + ",filled=" + filled + "]";
    }

    /**
     * equals.
     *
     * @param o obj
     * @return ans
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return Double.compare(width, square.width) <= 0.001
                && Double.compare(length, square.length) <= 0.001
                && Objects.equals(topLeft, square.topLeft);
    }

    /**
     * hash.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(topLeft, getSide(), getSide());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int) (topLeft.getPointX()), (int) (topLeft.getPointY()), (int) (width), (int) (width));
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        topLeft.setPointX(topLeft.getPointX() + getVelocity().getPointX());
        topLeft.setPointY(topLeft.getPointY() + getVelocity().getPointY());

        if (topLeft.getPointX() <= 0 || topLeft.getPointX() + width >= panelWidth) {
            getVelocity().setPointX(-getVelocity().getPointX());
        }
        if (topLeft.getPointY() <= 0 || topLeft.getPointY() + width >= panelHeight) {
            getVelocity().setPointY(-getVelocity().getPointY());
        }
    }
}
