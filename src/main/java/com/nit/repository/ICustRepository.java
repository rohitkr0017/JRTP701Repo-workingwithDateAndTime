package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nit.entity.Customer;

import jakarta.transaction.Transactional;

public interface ICustRepository extends CrudRepository<Customer, Integer> {
	
	//@Query("from com.nit.entity.Customer where billAmount>?1 and billAmount<?2")
	@Query("from com.nit.entity.Customer where billAmount>:min and billAmount<:max")
	//public List<Customer> showDataByBillAmountRange(double min,double max);
	public List<Customer> showDataByBillAmountRange(@Param("min") double min, @Param("max") double max);
	
	@Query("select cname,caddress from Customer where caddress=?1")
	public List<Object[]> showByAddress(String city);
	
	@Query("from Customer where caddress in(:add1,:add2) order by caddress")
	public List<Customer> showCustomerByAddress(String add1,String add2);
	
	@Query("select cno,cname,billAmount from Customer where billAmount between :start and :end")
	public List<Object[]> showCustomerByBillAmount(double start,double end);
	
	
	@Query("select cname from Customer where cname like :initialChars")
	public List<String> showCustomerByInitialCharacter(String initialChars);
	
	
	@Transactional
	@Modifying
	@Query("update Customer set billAmount=billAmount-(billAmount*:discount/100.0) where caddress in(:city1,:city2)")
	public int updateCustomerBillAmountWithDiscountForCityNames(String city1,String city2,float discount);
	
	
	@Query("from Customer where cname=:name")
	public Customer fetchByCustomerName(String name);
	
	@Query("select cno,cname,billAmount from Customer where cname=:name")
	public Object fetchCustomerDataByName(String name);
	
	@Query("select billAmount from Customer where cname=:name")
	public Double fetchCustomerBillAmountByName(String name);
	
	
	@Query("select count(*) from Customer")
	public long fetchCustomerCount();
	
	@Query("select count(distinct cname) from Customer")
	public long fetchUniqueCustomerNameCount();
	
	@Query("select count(*),max(billAmount),min(billAmount),avg(billAmount),sum(billAmount) from Customer")
	public Object fetchCustomerAggregateData();
	
	
	//-------------Native SQl Query-----------------
	
	@Query(value="INSERT INTO CUSTOMER(CNAME,CADDRESS,BILLAMOUNT) VALUES(:name,:address,:amount)",nativeQuery =true)
	@Transactional
	@Modifying
	public int registerCustomer(String name,String address,double amount);
	
	
	@Query(value = "SELECT now() FROM DUAL",nativeQuery = true)
	public String showSystemDate();
	
	
	@Query(value = "create table temp2(col1 integer,col2 varchar(20))",nativeQuery = true)
	@Modifying
	@Transactional
	public int createTable();
	
	
	
	
	
	
	
	
	
	
	
	
}
