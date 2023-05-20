package in.ineuron.service;

import org.springframework.stereotype.Service;

import in.ineuron.model.Employee;
import in.ineuron.model.EmployeePage;
import in.ineuron.model.EmployeeSearchCriteria;
import in.ineuron.repository.EmployeeCriteriaRepository;
import in.ineuron.repository.EmployeeRepository;
import org.springframework.data.domain.Page;


@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
    private final EmployeeCriteriaRepository employeeCriteriaRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           EmployeeCriteriaRepository employeeCriteriaRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCriteriaRepository = employeeCriteriaRepository;
    }

    public Page<Employee> getEmployees(EmployeePage employeePage,
                                       EmployeeSearchCriteria employeeSearchCriteria){
        return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
