package zk.test.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zk.test.entities.Department;
import zk.test.service.EmployeeService;
import zk.test.entities.Employee;
import zk.test.service.ExportExcelService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by zk on 2017/5/25.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ExportExcelService exportExcelService;

    @RequestMapping("getEmps")
    @ResponseBody
    public List getEmps(ModelMap map, HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String param = request.getParameter("param");
        System.out.println(name);
        System.out.println(age);
        System.out.println(param);
        List<Employee> emps = employeeService.getEmps(4);
        for (Employee emp : emps){
            System.out.println(emp);
            System.out.println(emp.getDepartment());
        }
        map.put("emps",emps);
       // return "list";
        return employeeService.getEmps(4);
    }

    @RequestMapping("getEmpAndDept")
    public String getEmpAndDept(ModelMap map){
        List<Employee> emps = employeeService.getEmpAndDept();
        for (Employee employee : emps){
            System.out.println(employee);
            System.out.println(employee.getDepartment());
        }
        map.put("emps",emps);
        return "list";
    }

    @RequestMapping("getAll")
    public String getAll(ModelMap map){
        List<Employee> emps = employeeService.getAll();
        for (Employee employee : emps){
            System.out.println(employee);
        }
        map.put("emps",emps);
        return "list";
    }

    @RequestMapping("getAllEmps")
    public String getEmp(ModelMap map){
        List<Employee> emps = employeeService.getEmps();
        for (Employee employee : emps){
            System.out.println(employee);
        }
        map.put("emps",emps);
        return "list";
    }

    @RequestMapping("insertEmp")
    public String insertEmp(){
        employeeService.insertEmp(new Employee(null,"zhilian2","2","zhilian@126.com",new Department(1,null)));
        return "redirect:getAllEmps";
    }

    @RequestMapping("export")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Employee> emps = employeeService.getEmpAndDept();
        String[] excelHeader = {"id","email","gender","name","department"};
        HSSFWorkbook wb = exportExcelService.export(emps,excelHeader);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=student.xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
