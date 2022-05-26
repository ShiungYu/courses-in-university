public class EmployeeTest {
    
    public static void main(String[] args)
    {
        Employee employee1=new Employee("Bob","Jones",34500.00);
        Employee employee2=new Employee("Susan","Baker",37809.00);

        System.out.printf("Employee 1: %s %s; Yearly Salary: %.2f%n",employee1.getFirstName(),employee1.getLastName(),employee1.getSalary());
        System.out.printf("Employee 2: %s %s; Yearly Salary: %.2f%n",employee2.getFirstName(),employee2.getLastName(),employee2.getSalary());

        System.out.println("Increasing employee salaries by 10%");
        employee1.increaseSalary(0.1);
        employee2.increaseSalary(0.1);

        System.out.printf("Employee 1: %s %s; Yearly Salary: %.2f%n",employee1.getFirstName(),employee1.getLastName(),employee1.getSalary());
        System.out.printf("Employee 2: %s %s; Yearly Salary: %.2f%n",employee2.getFirstName(),employee2.getLastName(),employee2.getSalary());
    }
}
