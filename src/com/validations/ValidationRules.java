package com.validations;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Exceptions.CustomException;
import com.core.Customer;
import com.core.MessPlan;

public class ValidationRules {
	
	public static Pattern EMAIL_PATTERN = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
	public static Pattern MOBILE_NO=Pattern.compile("^[0-9]{10}$");

    // Improved method name and return value
    public static boolean isEmailFormatValid(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public static Customer checkForEmailPass(String email, String pass, Map<Integer, Customer> mp) throws CustomException {
        // Use the isEmailFormatValid method for email format validation
        if (isEmailFormatValid(email)!=true) {
            throw new CustomException("Wrong email pattern");
        }

        Customer cust = mp.values().stream()
                .filter(customer -> email.equals(customer.getEmail()))
                .findFirst()
                .orElse(null);

        if (cust == null) {
            throw new CustomException("Wrong email");
        }

        if (!pass.equals(cust.getPassword())) {
            throw new CustomException("Wrong Password");
        }

        System.out.println("Successfully sign in");
        return cust;
    }

    public static Customer checkForDuplicate(String email, Map<Integer, Customer> map) throws CustomException {
        if (map.values().stream().anyMatch(c -> email.equals(c.getEmail()))) {
            throw new CustomException("Duplicate User");
        }

        System.out.println("No Duplicate user found");
        return new Customer(email); 
    }

    // Removed the unnecessary creation of a Customer object
    public static Customer validateAllInput(int id, String name, String email, String password,
                                            String address,String phoneno, 
                                            String plan,Map<Integer, Customer> map) throws CustomException {
       MessPlan plans=MessPlan.valueOf(plan);
    	checkForDuplicate(email, map);
        validateMessPlan(plan,plans.getCost(), map);
        validateMobileNumber(phoneno,map);
        return new Customer(id, name, email, password, address, phoneno, MessPlan.valueOf(plan));
    }
    
    public static boolean validateMessPlan(String plan,double Regisamt,Map<Integer,Customer> map) throws CustomException {
    	MessPlan mplan=MessPlan.valueOf(plan);
    	if(mplan.getCost()!=Regisamt) {
    		throw new CustomException("Registration ammount not matching");
    	}
    	return true;
    }
    public static Map<Integer,Customer> validateMobileNumber(String mono,Map<Integer,Customer> map) throws CustomException {
    	Matcher matcher=MOBILE_NO.matcher(mono);
    	if(matcher.matches()==true) {
    	return map;
    }else {
    	throw new CustomException("Wrong mobile number");
    }
    
}
}
