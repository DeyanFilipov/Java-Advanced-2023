package JavaOOP.Polymorphism.Lab.Shapes_02;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 * (this.height + this.width);
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = this.height * this.width;
        super.setArea(result);
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
