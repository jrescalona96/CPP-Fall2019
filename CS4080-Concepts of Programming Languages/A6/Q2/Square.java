class Square extends Rectangle {

    // constructor
    public Square() {
        super(0, 0);
    }   

    public Square(double e) {
        super(e, e);
    }   

    // set methods
    public void setEdge(double e) {
        super.l = e;
        super.w = e;
    }
    
    @Override
    public void dynamicArea() {
        this.area = this.l * this.w;
        System.out.printf("Square dynamicArea(): %.2f sq. units\n" , this.area);
    }
}