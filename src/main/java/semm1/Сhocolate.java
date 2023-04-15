package semm1;

public class Сhocolate extends Product{
    private int gram;
    private int caloric;



    public int getGram() {
        return gram;
    }



    public Сhocolate(String name, double price, int gram, int caloric){
        super(name, price);
        this.gram = gram;
        this.caloric = caloric;
    }

    @Override
    String displayInfo() {
        //return super.displayInfo();
        return String.format("%s - %s - %f - %d", gram, name, price, caloric);

    }

}
