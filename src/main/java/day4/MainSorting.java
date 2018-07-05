package day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainSorting {
    public static void main(String[] args) {
        MainSorting p = new MainSorting();
        p.start();
    }

    private void start() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "Somkiat", 200));      
        employees.add(new Employee(2, "Kiatsom", 300));
        employees.add(new Employee(3, "SomSom", 500));
        
        //Anonymous class approach
        /*Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                //-1 = Descending, 0 = Do nothing, 1 = Ascending
                return e1.getName().compareTo(e2.getName());
            }
        });*/
        
        //Lambda approach
        Comparator<Employee> withLambda = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
        
        //Collections.sort(employees, new EmployeeSort());
        Collections.sort(employees, withLambda);
        
        employees.forEach(System.out::println);
    }
    
    //Using implemented class is more recommended
    private class EmployeeSort implements Comparator<Employee>{
        @Override
        public int compare(Employee e1, Employee e2) {
            // TODO Auto-generated method stub
            return e1.getName().compareTo(e2.getName());
        }
    }
        
}
