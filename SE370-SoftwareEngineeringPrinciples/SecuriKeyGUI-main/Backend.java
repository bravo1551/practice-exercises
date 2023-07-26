import java.io.File; 	// import file class
import java.io.FileNotFoundException;
import java.io.FileWriter; // import file writer class
import java.io.IOException; // import IOExceptions error handling
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Backend {
	
	public static void errorHandle()
	{
		System.out.println("An error has occured.");		
	}

	public static void makeFile(String info)
	{
		try {
			File myObj = new File(info);
			if (myObj.createNewFile()) {  
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists");
			}
		} catch(IOException e) {
				errorHandle();
				e.printStackTrace();
			}	
	}

	public static boolean doesFileExist(String info)
	{
		try {
			File myObj = new File(info);
			if (myObj.createNewFile()) {  
				return false;
			} else {
				return true;
			}
		} catch(IOException e) {
				errorHandle();
				e.printStackTrace();
			}	
		return false;

	}
	
	public static void WriteToFile(String info, String data)
	{
		try {
			FileWriter myWriter = new FileWriter(info);
			myWriter.write(data);
			myWriter.close();
			
		} catch (IOException e)
		{
			errorHandle();
			e.printStackTrace();
		}
	}

	public static int readFile(String info)
	{
		int data;
		try {
			File myObj = new File(info);
			Scanner myReader = new Scanner(myObj);
			
			while(myReader.hasNextLine()){
				data = Integer.parseInt(myReader.nextLine());
				return data;
			}
			myReader.close();

			
		} catch (FileNotFoundException e)
		{
			System.out.println("An error has occured.");
			errorHandle();
			e.printStackTrace();
		}
		return 0;
	}

	public static void firstTimeUser(){

		if (doesFileExist("User.txt") == true){
			checkUser();
		}
		else{
		Scanner user = new Scanner(System.in);
		System.out.println("Please create your password.");

		String pass = user.nextLine();
		pass = Integer.toString(pass.hashCode());
		makeFile("User.txt");
		WriteToFile("User.txt", pass);
		}	
	}

	public static void checkUser(){
		int checkPass, userPass; 

		Scanner user = new Scanner(System.in);
		System.out.println("Please enter your password.");

		String pass = user.nextLine();
		userPass = pass.hashCode();
		checkPass = readFile("User.txt");
		if (userPass == checkPass)
		{
			System.out.println("Acess granted");
		}
		else 
		{
			System.out.println("Acess Denied");
		}

	}

	public boolean checkLogin(JButton button){
		String x,y,z;
		int checkPass, userPass;
		try{
		  x = (button.getText());
	
		  userPass = x.hashCode();
		  checkPass = readFile("User.txt");
		  if (userPass == checkPass)
		  {
			System.out.println("Acess granted");
			return true;
		  }
		  else 
		  {
			System.out.println("Acess Denied");
			return false;
		  }
	
		}catch(Exception e){
		  System.out.println(e);
		  JOptionPane.showMessageDialog(null, 
			  e.toString(),
			  "Error", 
			  JOptionPane.ERROR_MESSAGE);
		}
		return false;
	  }
	public static void main(String[] args) {
		firstTimeUser();
		//System.out.println(readFile("Passwords.txt"));
	}
}
