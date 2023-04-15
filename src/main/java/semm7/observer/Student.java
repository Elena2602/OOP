package semm7.observer;


public class Student implements Observer {

    private  String name;
    private double salary;

    public Student(String name) {
        this.name = name;
        salary = 5000;
    }

    @Override
    public void receiveOffer(String nameVacancy, String companyName, Double salary) {
        if (this.salary < salary){
            System.out.printf("Студент %s >>> Мне нужна работа %s! [%s - %f]\n", name, nameVacancy, companyName, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Студент %s >>> Я найду работу получше чем %s! [%s - %f]\n", name, nameVacancy, companyName, salary);
        }
    }
}
