package zk.test.mapper;

import zk.test.entities.Department;

import java.util.List;

/**
 * Created by zk on 2017/5/25.
 */
public interface DepartmentMapper {

    public List<Department> getAllDept(Integer id);
}
