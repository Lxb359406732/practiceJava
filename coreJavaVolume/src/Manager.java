public class Manager extends Employee
{
    private double bonus;

    public Manager(String name,double s,int year,int month,int day)
    {
        super(name,s,year,month,day);
        bonus=0;
    }

    public void setBonus(double bonus)
    {
        this.bonus=bonus;
    }

    @Override
    public double getSalary()
    {
        double baseSalary=super.getSalary();
        return baseSalary+bonus;
    }

    public static void main(String[] args)
    {
        Manager boss=new Manager("Boss",10000,1970,2,2);
        boss.setBonus(50000);
        System.out.println("name="+boss.getName()+",salary="+boss.getSalary()+",hireDay="
                +boss.getHireDay());
    }
}
