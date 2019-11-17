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