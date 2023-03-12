import java.util.*;

public class EmployeeSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\n***********************************************************************************");
            System.out.println("Employee Payroll System");
            System.out.println("\nMenu:");
            System.out.println("\nPlease pick your choice !!!");
            System.out.println("1. Add employee");
            System.out.println("2. Display pay slip for employee");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter employee name: ");
                String name = input.nextLine();
                System.out.print("Enter employee ID: ");
                int id = input.nextInt();
                System.out.print("Enter monthly salary: ");
                double salary = input.nextDouble();
                employees.add(new Employee(name, id, salary));
            } else if (choice == 2) {
                System.out.print("Enter employee ID: ");
                int id = input.nextInt();
                Employee e = null;
                for (Employee emp : employees) {
                    if (emp.getId() == id) {
                        e = emp;
                        break;
                    }
                }
                if (e == null) {
                    System.out.println("Employee not found.");
                } else {
                    System.out.println("Pay slip for " + e.getName() + ":");
                    System.out.println("Gross pay: " + e.getSalary());
                    System.out.println("Tax: " + e.calculateTax());
                    System.out.println("National insurance: " + e.calculateNationalInsurance());
                    System.out.println("Net pay: " + e.calculateNetPay());
                    System.out.println("***********************************************************************************");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice.");
                break;
            }
        }
    }
}

class Employee {
    private String name;
    private int id;
    private double salary;
    private double taxRate = 0.2;
    private double nationalInsuranceRate = 0.12;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateTax() {
        return salary * taxRate;
    }

    public double calculateNationalInsurance() {
        return salary * nationalInsuranceRate;
    }

    public double calculateNetPay() {
        return salary - calculateTax() - calculateNationalInsurance();
    }
}