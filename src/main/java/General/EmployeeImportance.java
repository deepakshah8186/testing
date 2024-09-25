package General;
// VERY IMP : https://leetcode.com/problems/employee-importance/description/
// Given an integer id that represents an employee's ID, return the total
// importance value of this employee and all their direct and indirect subordinates.

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
};

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {

      //  Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
      //  Output: 11
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(Employee employee : employees) {
            int employeeId = employee.getId();
            int importance = employee.getImportance();
            map.put(employeeId,importance);
        }

        for(int i=0;i<employees.size();i++) {
            Employee employee = employees.get(i);
            if(employee.id == id) {
                sum = employee.getImportance();
                List<Integer> subordinates = employee.getSubordinates();
                for(int j=0;j<subordinates.size();j++) {
                    int subordinate = subordinates.get(j);
                    int importance = map.get(subordinate);
                    sum = sum + importance;
                }
            }

        }

        System.out.println("Employee " + id + " sum: " + sum );
        return 0;

    }

    public static void main(String[] args) {
        EmployeeImportance employeeImportance = new EmployeeImportance();
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setImportance(5);
        employee1.setSubordinates(Arrays.asList(2,3));

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setImportance(5);

        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setImportance(3);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        employeeImportance.getImportance(employees,1);

    }
}
