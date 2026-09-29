package com.pavan.EmployeeCrud;

import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class EmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudApplication.class, args);
	}
//	@Bean
//	CommandLineRunner insertEmployee(EmployeeService service){
//		return args -> {
//			Employee employee = new Employee();
//			employee.setName("Pavan");
//			employee.setEmail("pk5496117@gmail.com");
//			employee.setSalary(new BigDecimal(95000.00));
//			employee.setDepartment("IT");
//			Employee savedEmployee = service.insertEmployee(employee);
//		};
//	}
}
