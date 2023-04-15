package DZ2;

class Cat {

    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }

    static class Plate {

        private int food;

        int getFood() {
            return food;
        }

        Plate(int food) {
            this.food = food;
        }

        void decreaseFood(int n) {
            food -= n;
        }

        void increaseFood() {
            this.food += 500;
            System.out.println("В миску добавили 500 грамм корма");
        }

        boolean checkFood(int n) {
            return (food - n) >= 0;
        }

    }
}
