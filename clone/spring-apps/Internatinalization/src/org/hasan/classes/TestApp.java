package org.hasan.classes;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) {
	
	TestApp t = new TestApp();
		
	Scanner s = new Scanner(System.in);
	System.out.print("Enter language code:");
	String lang = s.next();
	
	System.out.print("Enter Country code:");
	String country = s.next();
		
	// create object of Locale class
	Locale locale = new Locale(lang, country);
	
	// get bundle 
	ResourceBundle bundle = ResourceBundle.getBundle("message", locale);
	
	// get messages
	System.out.println(bundle.getString("message1"));

	}	
}