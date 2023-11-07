package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.core.Customer;
import com.core.MessPlan;
import static com.validations.ValidationRules.*;
public class UtilityForMess {
//	int id, String name, String email, String password, String address, LocalDate registerDate,
//	LocalDate olanEndDate, String phoneno, MessPlan plan, double final_ammount			
	
	public static List<Customer> populateList(){
		
		List<Customer> list=new ArrayList<>();
		list.add(new Customer(101,"shantanu","sk1.dac@gmail.com","100","nanded","454646",MessPlan.MONTHLY));
		list.add(new Customer(102,"ram","ram34.dac@gmail.com","12","mumbai","454646",MessPlan.YEARLY));
		list.add(new Customer(103,"vaibhav","vabhavt.dac@gmail.com","123","pune","454646",MessPlan.QUARTERLY));
		list.add(new Customer(104,"abhi","abhi22.dac@gmail.com","1234","noida","454646",MessPlan.MONTHLY));
		list.add(new Customer(105,"rahul","rahulgg.dac@gmail.com","12345","nashik","454646",MessPlan.HALFYEAR));
		
		return list;
	}
	public static Map<Integer,Customer> populateMap(List<Customer> list1){
		Map<Integer,Customer> mp=new HashMap<>();
		mp=list1.stream().collect(Collectors.toMap(c->((Customer) c).getId(),c->c));
		return mp;
	}
}
