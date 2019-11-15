class Rectangle {

    // statically bound area()
    public static void staticArea(double l, double w) {
        System.out.printf("Rectangle staticArea(): %.2f sq. units\n", l * w);
    }

    // dynamically bound area()
    public void dynamicArea(double l, double w) {
        System.out.printf("Rectangle dynamicArea(): %.2f sq. units\n", l * w);
    }
}

class Square extends Rectangle {
    // dynamically bound area()
    @Override
    public void dynamicArea(double l, double w) {
        System.out.printf("Square dynamicArea(): %.2f sq. units\n", l * w);
    }
}

class Test {
    public static void main(String[] args) {
        // declarations
        final int size = 100; // test case repetetions
        long startTime;
        Rectangle square = new Square();

        // call to dynamically bound method
        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            square.dynamicArea(5, 5);
        }
        long dynamicTime = System.currentTimeMillis() - startTime;

        // call to statically bound method
        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Rectangle.staticArea(5, 5);
        }
        long staticTime = System.currentTimeMillis() - startTime;

        System.out.printf("\nTime to finish %d calls:\n", size);
        System.out.printf("Static Method = %d ms\n", staticTime);
        System.out.printf("Dynamic Method = %d ms\n", dynamicTime);
    }
}