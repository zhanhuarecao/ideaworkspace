package zk.test.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import zk.test.entities.Employee;

import java.util.Collection;
import java.util.List;

/**
 * Created by zk on 2017/5/25.
 */
public interface EmployeeMapper {


    @Cacheable(value = "getAllEmp")
     List<Employee> getAllEmp(Integer id);

    @Cacheable(value = "getEmpAndDep")
     List<Employee> getEmpAndDep();

    @Select("select id,last_name lastName,gender,email from tb1_employee")
     List<Employee> getAll();


     List<Employee> getEmps();

     void insertEmp(Employee employee);
}
