package de.iteratec.spockworkshop;

public class Employee {

    enum Role { DEVELOPER, ARCHITECT, PROJECT_MANAGER, BOSS }
    
    private String name;
    private Role position;
    private int salary;

    public Employee() {

    }

    public Employee(String name, Role Position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getPosition() {
        return position;
    }

    public void setPosition(Role position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
