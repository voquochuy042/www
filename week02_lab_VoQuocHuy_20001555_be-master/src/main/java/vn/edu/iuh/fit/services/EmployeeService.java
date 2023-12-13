package vn.edu.iuh.fit.services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class EmployeeService {
    @Inject
    EmployeeRepository employeeRepository;
    public boolean add(Employee e){
        return employeeRepository.add(e);
    }
    public List<Employee> getAll(int page){
        return employeeRepository.getAllEmployee(page);
    }

    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }
    public Optional<Boolean> update(Employee e){
        Optional<Employee> optional = findById(e.getId());
        if (optional.isEmpty())
            return Optional.empty();
        return Optional.of(employeeRepository.update(e));
    }
    //aka delete
    public Optional<Boolean> updateStatus(long id){
        Optional<Employee> em = findById(id);
        if (em.isEmpty()) return Optional.empty();
        return Optional.of(employeeRepository.updateStatus(id, EmployeeStatus.ON_LEAVE));
    }
}
