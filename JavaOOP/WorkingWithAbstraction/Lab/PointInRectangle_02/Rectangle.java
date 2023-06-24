package JavaOOP.WorkingWithAbstraction.Lab.PointInRectangle_02;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle (Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }
    public boolean contains(Point point) {
        boolean isXBasedInside = this.getBottomLeft().getX() <= point.getX() &&
                this.getTopRight().getX() >= point.getX();
        boolean isYBasedInside = this.getBottomLeft().getY() <= point.getY() &&
                this.getTopRight().getY() >= point.getY();
        return isXBasedInside & isYBasedInside;
     }
}
