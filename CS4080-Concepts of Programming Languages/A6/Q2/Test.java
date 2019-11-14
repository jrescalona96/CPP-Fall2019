import java.util.Random;

class Test {
    public static void main(String[] args) {
        // declarations
        final int size = 1000; // test case repetetions
        long startTime;
        Random rand = new Random();
        Rectangle rectangle;
        Rectangle square;

        // call to statically bound method
        startTime = System.currentTimeMillis();
        for(int i = 0; i < size; i++) {
            rectangle = new Rectangle(Math.random() * 10, Math.random() * 10);
            rectangle.staticArea();
        }
        long staticTime = System.currentTimeMillis() - startTime;

        System.out.println(); //break line
        
        startTime = System.currentTimeMillis();
        // call to dynamically bound method
        for(int i = 0; i < size; i++) {
            square = new Square(Math.random() * 10);
            square.dynamicArea();
        }
        long dynamicTime = System.currentTimeMillis() - startTime;

        System.out.printf("\nTime to finish %d calls:\nStatic Method = %d ms\nDynamic Method = %d ms\n", size , staticTime, dynamicTime); 
    }
}