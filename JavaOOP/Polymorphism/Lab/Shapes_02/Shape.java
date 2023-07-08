package JavaOOP.Polymorphism.Lab.Shapes_02;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        if (perimeter == null) {
            calculatePerimeter();
        }
        return perimeter;
    }

    public Double getArea() {
        if (area == null) {
            calculateArea();
        }
        return area;
    }




}
