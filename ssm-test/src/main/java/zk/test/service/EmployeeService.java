package zk.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zk.test.entities.Employee;
import zk.test.mapper.EmployeeMapper;

import java.util.List;

/**
 * Created by zk on 2017/5/25.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> getEmps(Integer id){
        return employeeMapper.getAllEmp(id);
    }

    public List<Employee> getEmpAndDept(){
        return employeeMapper.getEmpAndDep();
    }

    public List<Employee> getAll(){
        return employeeMapper.getAll();
    }


    public List<Employee> getEmps(){
        return employeeMapper.getEmps();
    }

    public void insertEmp(Employee employee){
        employeeMapper.insertEmp(employee);
    }
}
