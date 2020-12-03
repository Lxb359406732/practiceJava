import java.time.LocalDate;
import java.util.Objects;

public class EmployeeTest {
    public static void main(String[] args)
    {
        Employee[] staff=new Employee[3];
        staff[0]=new Employee(null,9000,1999,1,1);
        staff[1]=new Employee("little B",10000,1999,2,2);
        staff[2]=new Employee("little C",12000,1999,3,3);

        for(Employee e:staff)
            e.raiseSalary(5);
        for(Employee e:staff)
        System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="
        +e.getHireDay());

    }
}
class Employee
{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n,double s,int year,int month,int day)
    {
        name= Objects.requireNonNull(n,"The name can not be null");
        salary=s;
        hireDay=LocalDate.of(year,month,day);
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise=salary*byPercent/100;
        salary+=raise;
    }


}
