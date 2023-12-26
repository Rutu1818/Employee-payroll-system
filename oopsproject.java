import java.util.*;

//employee payroll system

abstract class Employee 
{
    private String name;
    private int id;

    public Employee(String name, int id) 
    {
        this.name = name;
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public int getId() 
    {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() 
    {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee 
{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) 
    {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() 
    {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee 
{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) 
    {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() 
    {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem 
{
    private ArrayList<Employee> employeeList;

    public PayrollSystem() 
    {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee emp) 
    {
        employeeList.add(emp);
    }

    public void removeEmployee(int id) 
    {
        Employee empToRemove = null;
        for (Employee i : employeeList) 
        {
            if (i.getId() == id) 
            {
                empToRemove = i;
                break;
            }
        }
        if (empToRemove != null) 
        {
            employeeList.remove(empToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee i : employeeList) 
        {
            System.out.println(i);
        }
    }
}

public class oopsproject {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Priya Koala", 1, 6000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("Rutu Bhandari", 2 , 65000.0);
        PartTimeEmployee emp3 = new PartTimeEmployee("Alice Sharma", 3, 40, 1000.0);
        PartTimeEmployee emp4 = new PartTimeEmployee("Dishita Sharma", 4, 40, 1600.50);
        
        System.out.println("enter name of emp5: ");
        String name=sc.nextLine();
        System.out.println("enter id of emp5: ");
        int id=sc.nextInt();
        System.out.println("enter monthly salary for emp5: ");
        double monthlySalary=sc.nextDouble();
        FullTimeEmployee emp5 = new FullTimeEmployee(name, id, monthlySalary);

    
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("Removing Employee...");
        payrollSystem.removeEmployee(1);

        System.out.println("Final Employee Details:");
        payrollSystem.displayEmployees();
    }
}