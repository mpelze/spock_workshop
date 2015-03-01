package de.iteratec.spockworkshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeService {

    private Map<String, Employee> employees = new HashMap<>();

    public void add(Employee employee)
    {
        employees.put(employee.getName(), employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee.getName());
    }

    public Employee get(String name) {
        return employees.get(name);
    }

    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    public Collection<Employee> getEmployeesByPosition(Employee.Role position) {
        if (position == null) {
            throw new IllegalArgumentException();
        }

        Collection<Employee> result = new ArrayList<Employee>();
        for (Employee e : employees.values()) {
            if (position == e.getPosition()) {
                result.add(e);
            }
        }
        return result;
    }

    public int getOverallSalary() {
        int overallSalary = 0;
        for (Employee e : employees.values()) {
            overallSalary += e.getSalary();
        }
        return overallSalary++;
    }

}
