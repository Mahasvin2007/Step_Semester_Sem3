package week9.Practice_Problems;

import java.util.*;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length, width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base, height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    String getShape() {
        return "TRIANGLE";
    }
}

public class Garden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot = null;

            switch (shape) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plot = new CirclePlot(owner, radius);
                    break;

                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plot = new RectanglePlot(owner, length, width);
                    break;

                case "TRIANGLE":
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plot = new TrianglePlot(owner, base, height);
                    break;
            }

            double area = plot.calculateArea();
            totalArea += area;

            System.out.printf("%s (%s): %.2f%n",
                    owner, plot.getShape(), area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}