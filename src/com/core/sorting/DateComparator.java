package com.core.sorting;

import java.util.Comparator;

import com.core.Customer;

public class DateComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.getRegisterDate().compareTo(o2.getRegisterDate());
	}

	

}
