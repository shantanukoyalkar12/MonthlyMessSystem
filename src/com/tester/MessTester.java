package com.tester;

import static com.validations.SerivesForMess.*;
import static com.validations.ValidationRules.*;
import static com.utils.UtilityForMess.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.validations.*;
import com.Exceptions.CustomException;
import com.core.Customer;
import com.core.MessPlan;
import com.core.sorting.DateComparator;
import com.core.sorting.NameComparator;
import com.core.testing.PlanComparator;

public class MessTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, Customer> mp = new HashMap<>();// populateMap(populateList());
			boolean exit = false;
			while (!exit) {
				try {
				System.out
				.println("Enter Choice "
						+ "1: Sign up \n"
						+ "2: Sign in \n"
						+ "3:channge Password \n"
						+ "4:DisplayAll \n"
						+ "5:Sort by name \n"
						+ "6:sort by plan \n"
						+ "7:sort by date of registration \n"
						+ "8:Unsubscribe Customer \n"
						+ "9:Modify Firstletter \n"
						+ "10 count by plan \n"
						+ "11: Search Customer by address \n"
						+ "12: Discount for yearly pnas 20%");
					switch (sc.nextInt()) {
					case 1:// sign up
//						System.out.println("Enter int id, String name, String email, String password, "
//								+ "String address, LocalDate registerDate"
//								+ "LocalDate planEndDate, String phoneno, MessPlan plan,registration ammount");
					Customer cust = validateAllInput(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), mp);
					System.out.println("Enter email to check for duplicates,");
					//ustomer cust1=checkForDuplicate(sc.next(),mp);
						//mp = populateMap(populateList());
						mp.put(cust.getId(),cust);
						break;
					case 2:// sign in
						System.out.println("Enter you email and pasword");
						Customer customer = checkForEmailPass(sc.next(), sc.next(), mp);
						break;
					case 3:// change password
//						for(Customer c:mp.values()) {
//							System.out.println(c);
//						}
						System.out.println("Enter old email and password");
						Customer cust1 = checkForEmailPass(sc.next(), sc.next(), mp);
						System.out.println("Enter new password");
						String newPass = sc.next();
						if (cust1.getPassword().equals(newPass)) {
							throw new CustomException("Duplicate Password");
						} else {
							cust1.setPassword(newPass);
						}
						for (Customer c : mp.values()) {
							System.out.println(c);
						}
						break;
					case 4:
						for (Customer c : mp.values()) {
							System.out.println(c);
						}
						break;
					case 5:
						Collection<Customer> col = mp.values();
						List<Customer> list = col.stream().collect(Collectors.toList());
						Collections.sort(list, new NameComparator());
						for (Customer c1 : list) {
							System.out.println(c1);
						}
						break;
					case 6:
						Collection<Customer> col1 = mp.values();
						List<Customer> list2 = col1.stream().collect(Collectors.toList());
						Collections.sort(list2, new PlanComparator());
						for (Customer c1 : list2) {
							System.out.println(c1);
						}
						break;
					case 7:
						Collection<Customer> col2 = mp.values();
						List<Customer> list3 = col2.stream().collect(Collectors.toList());
						Collections.sort(list3, new DateComparator());
						for (Customer c1 : list3) {
							System.out.println(c1);
						}
						break;
					case 8:
						System.out.println("Enter plans to delete yearly monthly quarterly halfyear");
						unsubscribePlan(sc.next().toUpperCase(), mp);
						for (Customer c1 : mp.values()) {
							System.out.println(c1);
						}
						break;
					case 9:// modify first letter of all customer
						for (Customer c : mp.values()) {
							if (!c.getName().isEmpty()) {
								String name = c.getName().substring(0, 1).toUpperCase() + c.getName().substring(1);
								c.setName(name);
							}
						}
						mp.values().stream().forEach(s -> System.out.println(s));
						break;
					case 10:
						System.out.println("Enter plan you have choosen");
						int count = 0;
						MessPlan plan = MessPlan.valueOf(sc.next().toUpperCase());
						for (Customer s : mp.values()) {
							if (s.getPlan().equals(plan)) {
								count++;
							}
						}
						System.out.println("Number of Customers took " + count);
						break;
					case 11:
						System.out.println("Enter your city address");
						String city = sc.next();
						mp.values().stream().filter(s -> s.getAddress().equals(city))
								.forEach(s -> System.out.println(s.getName()));
						break;
					case 12:
						List<Customer> lit = mp.values().stream().filter(s -> s.getPlan().equals(MessPlan.YEARLY))
								.collect(Collectors.toList());
						lit.forEach(s -> s.setFinal_ammount(s.getFinal_ammount() * 0.8));
						mp = lit.stream().collect(Collectors.toMap(Customer::getId, c -> c));
						break;
					}

				} catch (Exception e) {
					System.out.println(e);
				}

			}

		}
	}

}
