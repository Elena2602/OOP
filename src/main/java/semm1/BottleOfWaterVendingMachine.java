package semm1;

import java.util.List;

public class BottleOfWaterVendingMachine {

    private final List<Product> products;

    public BottleOfWaterVendingMachine(List<Product> products){
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, int volume){

        for (Product product : products){
            if (product instanceof BottleOfWater){
                if (product.getName() == name && ((BottleOfWater)product).getVolume() == volume){
                    return (BottleOfWater)product;
                }
            }
        }
        return null;
    }

    //TODO: Разработать метод получения бутылки с молоком самостоятельно
    public  Сhocolate getChocolate(String name, double price, int gram, int caloric ){

        for (Product product : products){
            if (product instanceof  Сhocolate){
                if (product.getName() == name && (( Сhocolate)product).getGram() == gram){
                    return ( Сhocolate) product;
                }
            }
        }
        return null;
    }



}
