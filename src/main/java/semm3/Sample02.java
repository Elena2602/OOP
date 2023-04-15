package semm3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample02 {

    private static Random random = new Random();

    /**
     * TODO: 2. generateEmployee должен создавать различных сотрудников (Worker, Freelancer)
     *
     * @return
     */
    static Employee generateEmployee() {
        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surnames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};

        int salary = random.nextInt(200, 300);
        int index = random.nextInt(30, 50);
        int age = random.nextInt(25, 50);
        if (random.nextBoolean())
            return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], age, salary * index);
        else
            return new Freelancer(names[random.nextInt(5)], surnames[random.nextInt(5)], age, salary * index / 100);
    }

    public static void main(String[] args) {

//        Worker worker = new Worker("Анатолий", "Шестаков", 80000);
//        System.out.println(worker);

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("\n------------------------------------");
        System.out.println("Сортировка по ежемесячному доходу:\n");

        //Arrays.sort(employees, new NameComparator());
        Arrays.sort(employees, new SalaryComparator());

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        //  System.out.printf("\n*** Отсортированный массив сотрудников ***\n\n");
//        System.out.println("\n------------------------------------");
//        System.out.println("Сортировка по имени:\n");
//

        Arrays.sort(employees, new NameComparator());

    }
}


class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {

        //return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
        return Double.compare( o1.calculateSalary(), o2.calculateSalary());
    }
}

class NameComparator implements Comparator<Employee> {
//    @Override
//    public int compare(Employee o1, Employee o2) {
//        //return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
//        int res = o1.name.compareTo(o2.name);
//        if (res == 0){
//            res = Double.compare( o2.calculateSalary(), o1.calculateSalary());
//        }
//        return res;
//    }
@Override
public int compare(Employee o1, Employee o2) {
    return o1.name.compareTo(o2.name);
}
}
class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.age, o2.age);
    }
}

abstract class Employee {

    protected String name;
    protected String surName;
    protected double salary;
    protected int age;

    public Employee(String name, String surName, int age, double salary) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.age = age;
    }

    public abstract  double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Среднемесячная заработная плата: %.2f", name, surName, salary);
    }

//    @Override
//    public int compareTo(Employee o) {
//        return Double.compare( o.calculateSalary(), calculateSalary());
//    }
}

class Worker extends Employee{

    public Worker(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);

//        @Override
//    public double calculateSalary() {
//        return salary ;
        //TODO: Для фрилансера - return 20 * 5 * salary
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; %d лет; Рабочий; фиксированная з/п за месяц: %.2f", name, surName, age,
                salary);
    }

    @Override
    public double calculateSalary() {
        return salary;

    }
}

/**
 * TODO: 1. Доработать самостоятельно в рамках домашней работы
 */
class Freelancer extends Employee {

    public Freelancer(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary * 20 * 5;
    }

    @Override
    public String toString() {
        return String.format(
                "Сотрудник: %s %s; %d лет; Фрилансер; почасовая з/п: %.2f; средняя з/п за месяц (100 часов): %.2f",
                name, surName, age, salary, calculateSalary());
    }
}


