package de.iteratec.spockworkshop.solution

import de.iteratec.spockworkshop.Employee
import de.iteratec.spockworkshop.EmployeeService
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
      This operator prohibits the NPE. It is an implicit check for null. If the object before the ?. is null the whole
      expression just returns null.
     */


    /*
     Task 2: The service method getOverallSalary should return the sum of all salaries of all employees. Write a test
      case that checks if this really works.
     */

    def "summing up all salaries works"() {
        given:
        service.add(new Employee("Leonard Nimoy", Employee.Role.BOSS, 100000))
        service.add(new Employee("Zachary Quinto", Employee.Role.ARCHITECT, 50000))
        service.add(new Employee("William Shatner", Employee.Role.BOSS, 200000))

        // expect is a combination of when and then.
        expect:
        service.getOverallSalary() == 350000
    }

    /*
     Task 3: The service method getEmployeesByPosition returns all employees of type XYZ. The method should throw an
     IllegalArgumentException if the parameter "position" is null. Write a test case that checks if this exception is
     thrown. Do you know how you would do this with JUnit?
    */

    def "getting all employees of type null breaks"() {
        when:
        service.getEmployeesByPosition(null)

        then:
        thrown(IllegalArgumentException)
    }

}
