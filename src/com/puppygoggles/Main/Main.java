package com.puppygoggles.Main;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
  public static void main(String... args) throws Exception {
	  IntVisionAPI run = new IntVisionAPI();
	  
	  File inputFile = new File("breeds.txt");
	  ArrayList<String> breeds = new ArrayList<>();
	  
	  try(Scanner in = new Scanner(inputFile)){
		  while(in.hasNext()) {
			  String inputBreed = in.nextLine().toLowerCase();
			  breeds.add(inputBreed);
		  }
	  }
	  catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
	  }	  
	  
	  run.analyze(breeds);

	  
	  
	// Set up and execute a Google Cloud Storage request.
//	  MyStorage pic = new MyStorage();
//	  pic.getPicture();
//	  
    // Instantiates a client
  }
}