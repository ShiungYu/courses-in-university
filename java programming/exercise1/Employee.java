public class Employee {
    
    private String First_Name;
    private String Last_Name;
    private double salary;

    public Employee(String firstName, String lastName , double vsalary)
    {
        First_Name=firstName;
        Last_Name=lastName;

        if(vsalary>0.0)
            salary=vsalary;    
    }

    public String getFirstName()
    {
        return First_Name;
    }

    public String getLastName()
    {
        return Last_Name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void increaseSalary(double increaseRate)
    {
        salary=salary*(1+increaseRate);
    }
}
