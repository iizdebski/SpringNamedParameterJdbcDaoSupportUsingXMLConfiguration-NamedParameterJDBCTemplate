package com.izdebski.client;

import com.izdebski.model.Employee;
import com.izdebski.service.EmployeeService;
import com.izdebski.service.impl.EmployeeServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeServiceImpl.class);

        //createEmployee(employeeService);
        //getEmployeeById(employeeService);
        fetchAllEmployeeInfo(employeeService);
        //employeeService.updateEmployeeEmailById("Jimmy.s2031@yahoo.com", 2);
        //employeeService.deleteEmployeeById(1);
        ctx.close();
    }

    private static void fetchAllEmployeeInfo(EmployeeService employeeService){
    List<Employee> empList = employeeService.getAllEmployeesInfo();
        for (Employee employee : empList) {
            System.out.println(employee.getEmployeeId() + "\t" + employee.getEmployeeName() + "\t" + employee.getEmail() + "\t" + employee.getGender() + "\t" + employee.getSalary());
        }
    }

        private static void getEmployeeById(EmployeeService employeeService){
            Employee employee = employeeService.fetchEmployeeById(2);
            System.out.println(employee.getEmployeeId() + "\t" + employee.getEmployeeName());
    }

        private static void createEmployee(EmployeeService employeeService){

            Employee employee = new Employee();
            employee.setEmail("max.m@yahoo.com");
            employee.setEmployeeName("Max");
            employee.setGender("Male");
            employee.setSalary(70000.00);
            employeeService.addEmployee(employee);
        }
}