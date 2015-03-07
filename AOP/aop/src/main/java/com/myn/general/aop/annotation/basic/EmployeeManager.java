package com.myn.general.aop.annotation.basic;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
 
@Component
public class EmployeeManager
{
    public EmployeeDTO getEmployeeById(Integer employeeId) {
        System.out.println("Method getEmployeeById() called");
        return new EmployeeDTO();
    }
 
    public EmployeeDTO getEmployeeById1(String employeeId) {
        System.out.println("Method getEmployeeById() called");
        return new EmployeeDTO();
    }
    
    public List<EmployeeDTO> getAllEmployee() {
        System.out.println("Method getAllEmployee() called");
        return new ArrayList<EmployeeDTO>();
    }
 
    public void createEmployee(EmployeeDTO employee) {
        System.out.println("Method createEmployee() called");
    }
 
    public void deleteEmployee(Integer employeeId) {
        System.out.println("Method deleteEmployee() called");
    }
 
    public void updateEmployee(EmployeeDTO employee) {
        System.out.println("Method updateEmployee() called");
    }
}