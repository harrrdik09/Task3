import java.security.PublicKey;
import java.util.*;

public class Task3 {
    ArrayList<Employee> emp = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean add;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Task3 tt = new Task3();
        //int option;
        boolean flag = true;
        while(flag) {
            System.out.println("Choose option " );
            System.out.println("1 for AddEmployee");
            System.out.println("2 for showEmployee");
            System.out.println("3 for Print in Ascending Order by Name ");
            System.out.println("4 for Print in Desending Order by Salary ");
            System.out.println("5 Exit");

            int option = sc.nextInt();

            switch (option) {
                    case 1:
                    tt.addEmployee();
                    break;
                    case 2:
                    tt.showData();
                    break;
                case 3:
                    tt.nameAsc();
                    break;
                case 4:
                   // Collections.sort();
                    tt.salaryDec();
                    break;
                    case 5:
                    flag = false;
                    break;
            }
        }

    }

    public void addEmployee()
    {
        System.out.println("Insert Emp Name:");
        String name =sc.next();

        System.out.println("Insert Emp Age ");
        int id = sc.nextInt();

        System.out.println("Insert Emp Salary");
        Double dd = sc.nextDouble();

        add = emp.add(new Employee(name, id, dd));

    }

    public  void showData()
    {
       if (emp == null)
       {
           System.out.println("please Enter Emp Data");
       }
       else {
           for (Employee e:emp)
           {
               System.out.println(e);
           }
       }
    }

    public void nameAsc()
    {
        //Comparing
        //by Default Comparing in Ascending order
        emp.sort(Comparator.comparing((Employee e) -> e.Name));
        emp.forEach(System.out::println);
    }

    public void salaryDec() {
        Collections.sort(emp, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.Salary, o2.Salary);
            }
        });
        for (Employee e : emp) {
            System.out.println(e);
        }
    }

     static class Employee
    {
        String Name;
        int Age;
        Double Salary;

        Employee(String name,int age,Double salary)
        {
           // this.Name =name;
            this.Name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            this.Age= age;
            this.Salary = salary;


        }

        @Override
        public String toString() {
            return "Name :" + Name + "  Age" + Age + " Salary" + Salary ;
        }
    }
}
