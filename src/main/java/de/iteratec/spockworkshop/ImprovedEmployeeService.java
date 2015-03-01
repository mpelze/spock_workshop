package de.iteratec.spockworkshop;

import java.util.List;
import java.util.UUID;

public class ImprovedEmployeeService extends EmployeeService {

    LDAPService ldapService;


    public void add(Employee employee)
    {
        super.add(employee);
        // We generate the user password as a UUID. Not a very good solution but easy to implement :-)
        ldapService.createNewUser(employee.getName(), UUID.randomUUID().toString());
    }

    public void remove(Employee employee) {
        super.remove(employee);
        ldapService.deleteUser(employee.getName());
    }

    public boolean areAllEmployeesInLDAP() {
        boolean result = true;
        List<String> ldapUsers = ldapService.getUsers();
        for (Employee employee : getEmployees()) {
            if (!ldapUsers.contains(employee.getName())) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void setLDAPService(LDAPService ldapService) {
        this.ldapService = ldapService;
    }
}
