package de.iteratec.spockworkshop

import spock.lang.Specification

class EmployeeSpec extends Specification {

    static EmployeeService service;

    def setup() {
        service = new EmployeeService()
    }

    def "adding an employee works"() {
        given:
        String name = "Leonard Nimoy"
        Employee employee = new Employee(name, Employee.Role.BOSS, 100000)

        when:
        service?.add(employee)

        then:
        service?.get(name) == employee
    }


    /*
      Task 1: The setup() method does the same as before() in JUnit. It is executed before the test cases in this
      spec are called. Remove this method. The service variable is now null. See what the ? in the when and then
      clauses of the test case above does. It is the groovy safe navigation operator.
     */

    /*
     Task 2: The service method getOverallSalary should return the sum of all salaries of all employees. Write a test
      case that checks if this really works.
     */


    /*
     Task 3: The service method getEmployeesByPosition returns all employees of type XYZ. The method should throw an
     IllegalArgumentException if the parameter "position" is null. Write a test case that checks if this exception is
     thrown. Do you know how you would do this with JUnit?
    */

}
