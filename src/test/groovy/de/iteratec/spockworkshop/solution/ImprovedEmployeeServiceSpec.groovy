package de.iteratec.spockworkshop.solution

import de.iteratec.spockworkshop.Employee
import de.iteratec.spockworkshop.ImprovedEmployeeService
import de.iteratec.spockworkshop.LDAPService
import spock.lang.Specification

class ImprovedEmployeeServiceSpec extends Specification {

    ImprovedEmployeeService service

    def setup() {
        service = new ImprovedEmployeeService()
    }

    /*
      Task 1: The above test case is copied from EmployeeSpec. It fails because ImprovedEmployeeService communicates
      with another service (ldapService) to create the new user in LDAP. We don't want to test ldapService here
      so we have to mock it. Modify the above test case to set a ldapService mock into service.
     */

    def "adding an employee works"() {
        given:
        String name = "Leonard Nimoy"
        Employee employee = new Employee(name, Employee.Role.BOSS, 100000)
        LDAPService ldapMock = Mock()
        service.setLDAPService(ldapMock)

        when:
        service?.add(employee)

        then:
        service?.get(name) == employee
    }

    /*
      Task 2: Now that we have the mock we could check that the service.add(Employee) method really calls
      the LDAP service to create the user in LDAP. Add a statement to the then block that checks if our
      mock is called.
     */

    def "adding an employee works (with check for call to mock)"() {
        given:
        String name = "Leonard Nimoy"
        Employee employee = new Employee(name, Employee.Role.BOSS, 100000)
        LDAPService ldapMock = Mock()
        service.setLDAPService(ldapMock)

        when:
        service.add(employee)

        then:
        1 * ldapMock.createNewUser(name, _)
        service.get(name) == employee
    }

    /*
      Task 3: ImprovedEmployeeService has a method areAllEmployeesInLDAP that checks if all employees in the
      ImprovedEmployeeService data storage are also in LDAP. To do this the method requests all users from LDAPService
      (List<String> LDAPService.getUsers()). Write a test case for ImprovedEmployeeService.areAllEmployeesInLDAP. To
      do so you have to build a mock object that returns some name for getUsers.
     */

    def "checking if all users are in LDAP works"(){
        given:
        LDAPService ldapMock = Mock()
        ldapMock.getUsers() >> ["A", "B"]
        service.setLDAPService(ldapMock)
        service.add(new Employee("A", Employee.Role.DEVELOPER, 1000))
        service.add(new Employee("B", Employee.Role.DEVELOPER, 1000))

        when:
        boolean result = service.areAllEmployeesInLDAP()

        then:
        result
    }
}
