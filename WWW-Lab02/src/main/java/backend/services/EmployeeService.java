package backend.services;

import backend.enums.EmployeeStatus;
import backend.models.Employee;
import backend.repositories.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee) {
        employeeRepository.insertEmp(employee);
    }

    public boolean deleteEmp(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            final var employeeStatus = EmployeeStatus.TERMINATED;
            employeeRepository.setStatus(emp,employeeStatus);
            employeeRepository.update(emp);
            return true;
        }
        return false;
    }

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public boolean activeEmp(long id) {
        Optional<Employee> op = employeeRepository.findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setEmployeeStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public void updateEmp(Employee employee){
       employeeRepository.update(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAllEmp();
    }

}
