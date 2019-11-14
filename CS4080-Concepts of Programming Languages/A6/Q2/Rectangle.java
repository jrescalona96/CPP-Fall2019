class Rectangle {
    // fields
    protected double l;
    protected double w;
    protected double area;

    // constructors
    public Rectangle() {
        this.l = 0;
        this.w = 0;
    }

    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    // set methods
    public void setL(double l) {
        this.l = l;
    }

    public void setW(double w) {
        this.w = w;
    }

    // statically bound area()
    public void staticArea() {
         this.area = this.l * this.w;
         System.out.printf("Rectangle staticArea(): %.2f sq. units\n" , this.area);
    }

    // dynamically bound area()
    public void dynamicArea() {
        this.area = this.l * this.w;
        System.out.printf("Rectangle dynamicArea(): %.2f sq. units\n" , this.area);
    }
}