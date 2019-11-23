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
