package de.iteratec.spockworkshop

import spock.lang.Specification

class ImprovedEmployeeServiceSpec extends Specification {

    ImprovedEmployeeService service

    def setup() {
        service = new ImprovedEmployeeService()
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
      Task 1: The above test case is copied from EmployeeSpec. It fails because ImprovedEmployeeService communicates
      with another service (ldapService) to create the new user in LDAP. We don't want to test ldapService here
      so we have to mock it. Modify the above test case to set a ldapService mock into service.
     */

    /*
      Task 2: Now that we have the mock we could check that the service.add(Employee) method really calls
      the LDAP service to create the user in LDAP. Add a statement to the then block that checks if our
      mock is called.
     */

    /*
      Task 3: ImprovedEmployeeService has a method areAllEmployeesInLDAP that checks if all employees in the
      ImprovedEmployeeService data storage are also in LDAP. To do this the method requests all users from LDAPService
      (List<String> LDAPService.getUsers()). Write a test case for ImprovedEmployeeService.areAllEmployeesInLDAP. To
      do so you have to build a mock object that returns some name for getUsers.
     */
}
