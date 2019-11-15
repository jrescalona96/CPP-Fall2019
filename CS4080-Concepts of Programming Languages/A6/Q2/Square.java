class Square extends Rectangle {
    // dynamically bound area()
    @Override
    public void dynamicArea(double l, double w) {
        System.out.printf("Square dynamicArea(): %.2f sq. units\n", l * w);
    }
}