package semm7.observer;

public class Worker implements Observer {
    private  String name;
    private double salary;

    public Worker(String name) {
        this.name = name;
        salary = 40000;
    }

    @Override
    public void receiveOffer(String nameVacancy, String companyName, Double salary) {
        if (this.salary < salary){
            System.out.printf("Рабочий %s >>> Мне нужна работа %s! [%s - %f]\n", name, nameVacancy, companyName, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Рабочий %s >>> Я найду работу получше чем %s! [%s - %f]\n", name, nameVacancy, companyName, salary);
        }
    }
}
