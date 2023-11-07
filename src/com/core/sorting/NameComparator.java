package com.core.sorting;

import java.util.Comparator;

import com.core.Customer;

public class NameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
