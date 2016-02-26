package droneDeliverySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

	public String stopper() {
		StringBuilder sb = new StringBuilder();
		System.out.println("Do you want to add more products");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
		    sb.append(s);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();		
	}
	
	public String typeOfRequest() {
		StringBuilder sb = new StringBuilder();
		System.out.println("What kind of request do you want ");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
		    sb.append(s);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();	
	}
	
	public String[] askForLocation() {
		StringBuilder sb = new StringBuilder();
		System.out.println("Add coordinates");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
		    sb.append(s);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return sb.toString().split(" ");	
	}
	
	public String askForProductName() {
		StringBuilder sb = new StringBuilder();
		System.out.println("Enter product name");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
		    sb.append(s);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();		
	}
	
	public String askForProductQuantity() {
		StringBuilder sb = new StringBuilder();
		System.out.println("Enter product quantity");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
		    sb.append(s);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();		
	}
	
	public String askForHowMantProducts() {
		StringBuilder sb = new StringBuilder();
		System.out.println("How many products do you want");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    String s = bufferRead.readLine();
		    sb.append(s);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return sb.toString();		
	}
	
	
	
	
	
	
}
