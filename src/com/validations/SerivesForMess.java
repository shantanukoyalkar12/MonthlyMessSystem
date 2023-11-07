package com.validations;

import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.core.Customer;
import com.core.MessPlan;

public class SerivesForMess {
   public static void unsubscribePlan(String plan,Map<Integer,Customer> map) {
	MessPlan plans=MessPlan.valueOf(plan);
//	List<Customer> list=map.values().stream().collect(Collectors.toList());
	Iterator<Map.Entry<Integer, Customer>> iterator=map.entrySet().iterator();
	while(iterator.hasNext()) {
		Map.Entry<Integer,Customer> entry=iterator.next();
		if(entry.getValue().getPlan()==plans) {
			iterator.remove();
		}
	}
//	for (Map.Entry<Integer, Customer> entry : map.entrySet()) {
//        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//    }
	   
   }
}
