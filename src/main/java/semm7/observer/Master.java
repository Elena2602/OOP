package semm7.observer;

public class Master implements Observer {
    private  String name;
    private double salary;

    public Master(String name) {
        this.name = name;
        salary = 80000;
    }

    @Override
    public void receiveOffer(String nameVacancy, String companyName, Double salary) {
        if (this.salary < salary){
            System.out.printf("Мастер %s >>> Мне нужна работа %s! [%s - %f]\n", name, nameVacancy, companyName, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Мастер %s >>> Я найду работу получше чем %s! [%s - %f]\n", name, nameVacancy, companyName, salary);
        }
    }
}
