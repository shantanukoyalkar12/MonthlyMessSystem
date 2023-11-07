package com.core.testing;

import java.util.Comparator;

import com.core.Customer;

public class PlanComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.getPlan().compareTo(o2.getPlan());
	}

}
