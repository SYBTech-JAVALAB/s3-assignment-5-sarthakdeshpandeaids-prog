// Custom exception for invalid employee data
class InvalidEmployeeDataException extends Exception {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}

// Base class
class Employee {
    protected String name;
    protected double salary;
    protected String role;

    // Constructor using 'this' and 'super'
    public Employee(String name, double salary, String role) throws InvalidEmployeeDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Employee name cannot be empty!");
        }
        if (salary < 0) {
            throw new InvalidEmployeeDataException("Salary cannot be negative!");
        }
        if (role == null || role.trim().isEmpty()) {
            throw new InvalidEmployeeDataException("Role cannot be empty!");
        }

        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Role: " + this.role);
        System.out.println("Salary: ₹" + this.salary);
    }

    // Method to be overridden
    public void calculateBonus() {
        System.out.println("General employees receive a 5% bonus.");
        double bonus = this.salary * 0.05;
        System.out.println("Bonus: ₹" + bonus);
    }
}

// Specialized class for Manager
class Manager extends Employee {
    public Manager(String name, double salary) throws InvalidEmployeeDataException {
        super(name, salary, "Manager");
    }

    @Override
    public void calculateBonus() {
        System.out.println("Managers receive a 15% bonus.");
        double bonus = this.salary * 0.15;
        System.out.println("Bonus: ₹" + bonus);
    }
}

// Specialized class for Developer
class Developer extends Employee {
    public Developer(String name, double salary) throws InvalidEmployeeDataException {
        super(name, salary, "Developer");
    }

    @Override
    public void calculateBonus() {
        System.out.println("Developers receive a 10% bonus.");
        double bonus = this.salary * 0.10;
        System.out.println("Bonus: ₹" + bonus);
    }
}

// Demonstration class
public class EmployeeManagementDemo {
    public static void main(String[] args) {
        try {
            Employee e1 = new Manager("Ravi", 80000);
            Employee e2 = new Developer("Sneha", 60000);
            Employee e3 = new Employee("John", 40000, "Clerk");

            System.out.println("\n--- Employee Details ---");
            e1.displayInfo();
            e1.calculateBonus();

            System.out.println("\n-------------------------");
            e2.displayInfo();
            e2.calculateBonus();

            System.out.println("\n-------------------------");
            e3.displayInfo();
            e3.calculateBonus();

            // Example of invalid input
            System.out.println("\n--- Invalid Employee Example ---");
            Employee e4 = new Developer("", -50000); // triggers exception

        } catch (InvalidEmployeeDataException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
