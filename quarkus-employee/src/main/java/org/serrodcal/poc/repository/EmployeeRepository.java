package org.serrodcal.poc.repository;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.serrodcal.poc.dao.EmployeeDao;
import org.serrodcal.poc.domain.Employee;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepository {

    private EmployeeDao employeeDao;

    EmployeeRepository(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Multi<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    public Uni<Employee> getEmployee(Long id) {
        return employeeDao.findById(id);
    }

    public Multi<Employee> getEmployeesByDept(Long deptId) {
        return employeeDao.findByDept(deptId);
    }

    public Uni<Long> saveEmployee(Employee employee) { return employeeDao.save(employee.name, employee.deptId); }

    public Uni<Boolean> updateEmployee(Employee employee) { return employeeDao.update(employee.id, employee.name, employee.deptId); }

    public Uni<Boolean> deleteEmployee(Long id) { return employeeDao.delete(id); }

    public Uni<Boolean> unassignEmployees(Long deptId) { return employeeDao.unassignEmployees(deptId); }

}
