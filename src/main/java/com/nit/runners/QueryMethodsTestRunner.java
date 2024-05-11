package com.nit.runners;

import java.util.Arrays;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Customer;
import com.nit.repository.ICustRepository;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustRepository custRepo;

	@Override
	public void run(String... args) throws Exception {
		//custRepo.showDataByBillAmountRange(1000.0,7000.0).forEach(System.out::println);
		
		/*custRepo.showByAddress("Dhanbad").forEach(row->{
			for(Object obj:row)
				System.out.print(obj+" ");
			System.out.println();
		});
		System.out.println("----------------");
		
		
		custRepo.showCustomerByAddress("Dhanbad", "Ranchi").forEach(System.out::println);
		System.out.println("--------------------------------");
		
		custRepo.showCustomerByBillAmount(1000.0, 7000.0).forEach(row->{
			for(Object obj:row)
				System.out.print(obj+" ");
			System.out.println();
		});
		System.out.println("-----------------------");
		
		custRepo.showCustomerByInitialCharacter("R%").forEach(System.out::println);*/
		
		/*int n=custRepo.updateCustomerBillAmountWithDiscountForCityNames("Dhanbad", "Ranchi", 20.0f);
		System.out.println("No. of updated record:: "+n);
		*/
		
		/*Customer cust=custRepo.fetchByCustomerName("rohit");
		System.out.println("Complete single record: "+cust);
		System.out.println("---------------------");
		
		Object obj=custRepo.fetchCustomerDataByName("rohit");
		Object data[]=(Object[])obj;
		System.out.println("single record multiple column: "+Arrays.toString(data));
		System.out.println("---------------------");
		
		Double bill=custRepo.fetchCustomerBillAmountByName("rohit");
		System.out.println("rohit customer bill Amount is: "+bill);*/
		
		
		/*System.out.println("all customer count::"+custRepo.fetchCustomerCount());
		System.out.println("all customer unique names count::"+custRepo.fetchUniqueCustomerNameCount());
		Object row[]=(Object[])custRepo.fetchCustomerAggregateData();
		System.out.println("Results are::"+Arrays.toString(row));*/
		
		int n=custRepo.registerCustomer("Aarav", "Delhi", 9999.00);
		System.out.println(n+" record inserted");
		
		System.out.println(custRepo.showSystemDate());
		
		int n1=custRepo.createTable();
		System.out.println(n1+" table created");
		
		
	}

}
