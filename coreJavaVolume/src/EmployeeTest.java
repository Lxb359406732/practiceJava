
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 * wabiwabi
 */
public class EmployeeTest {
    public static void main(String[] args)
    {
        Employee[] staff=new Employee[4];
        staff[0]=new Employee("",9000,1999,1,1);
        staff[1]=new Employee("little B",10000,1999,2,2);
        staff[2]=new Employee("little C",12000,1999,3,3);
        staff[3]=new Employee();
        Arrays.sort(staff);
//        for(Employee e:staff)
//            e.raiseSalary(5);
        for(Employee e:staff)
        System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="
        +e.getHireDay());
        if(staff[1].equals(staff[0]))
            System.out.println("bulabula");

    }
}
class Employee implements Comparable<Employee>
{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee()
    {
        name="1";
        salary=10;

    }
    public Employee(String n,double s,int year,int month,int day)
    {
        name= Objects.requireNonNullElse(n,"unknown");
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

    /**
     *
     * @param byPercent the percent by which to raise the salary
     * @return the amount of the raise
     */
    public double raiseSalary(double byPercent)
    {
        double raise=salary*byPercent/100;
        salary+=raise;
        return raise;
    }

    public boolean equals(Employee other)
    {
        return name.equals(other.name);
    }

    public int compareTo(Employee other)
    {
        return Double.compare(salary,other.salary);
    }


}
