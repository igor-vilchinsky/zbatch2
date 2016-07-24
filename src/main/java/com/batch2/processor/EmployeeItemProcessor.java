package com.batch2.processor;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.batch2.model.Employee;
import com.batch2.restclient.RestClient;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

    private static final Logger log = LoggerFactory.getLogger(EmployeeItemProcessor.class);

    @Override
    public Employee process(final Employee employee) throws Exception {

    	Long employeeId = employee.getId();
    	final Employee transformedEmployee;
    	try {
    		transformedEmployee = RestClient.getEmployeeFromRestServiceById(employeeId);
    		transformedEmployee.setId(employeeId);
    	} catch(Exception e) {
    		return employee;
    	}
        
        log.info("Converting (" + employee + ") into (" + transformedEmployee + ")");
        return transformedEmployee;
    }

}
