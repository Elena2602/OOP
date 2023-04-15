package DZ2;

public class FoodCats {

    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Васька", 150, 3);
        cat[1] = new Cat("Федор", 100, 4);
        cat[2] = new Cat("Пушок", 130, 5);
        Cat.Plate plate = new Cat.Plate(500);
        System.out.println("У меня есть три кота: " + cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() +
                ", которые хотят есть каждые " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() +
                " и " + cat[2].getSatietyTime() + " час(а).");
        System.out.println("Кто-то из них больше ест, кто-то меньше. Сейчас в миске " + plate.getFood() +
                " грамм кошачьего корма. Посмотрим насколько его хватит, в данный момент коты очень голодны и начали кушать.\n");

        do {
            for (Cat i : cat) {


                if (i.getSatiety() == 0) {


                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }


                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " граммов корма и проголодается через "
                            + (i.getSatiety()) + " часа(ов)");
                }


                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС момента начала приема еды прошло " + TIME + " час. В миске осталось " + plate.getFood() + " граммов корма.\n");
            TIME++;

        } while (TIME <= 12);
    }
}
