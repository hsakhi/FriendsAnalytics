package com.wpi.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashMap;

import com.wpi.helpers.RandomGenerator;

public class DataCreation {
		// TODO Auto-generated method stub

	

	    public static void main(String[] args) {
	    	
	    	HashMap<Integer,String>countryDetails = new HashMap<Integer, String>();

	    	RandomGenerator personGenerator = new RandomGenerator("abcdefghijklmnopqrstuvwxyz","Person");
	    	RandomGenerator nationalityGenerator = new RandomGenerator("acefjklmnrstuvw","Nationality");
	    	RandomGenerator hobbyGenerator = new RandomGenerator("acefjklmnrstuvw","Hobby");
	    	GregorianCalendar gc = new GregorianCalendar();
	    	RandomGenerator friendshipdescgenerator = new RandomGenerator("abcdefghijklmnopqrstuvwxyz","FriendshipDesc"); 
	    	
	    	
	    	
	    	
	    	for(int j=1;j<=50;j++) {
	    		
		    	int nationalityNameLength = nationalityGenerator.getRandomNumberInRange(10, 20);

 
        		
        		String nationality = nationalityGenerator.generateRandomString(nationalityNameLength);
        		
        		while(countryDetails.containsValue(nationality)) {
        			nationality = nationalityGenerator.generateRandomString(nationalityNameLength);
        		}
        		
        		countryDetails.put(j, nationality);
        		
        	}
	    		
	    	
	    	
	    	HashMap<Integer,String>hobbyDetails = new HashMap<Integer,String>();
	    	
	    	for(int k=1;k<=100;k++)
	    	{
	    		
		    	int hobbyNameLength = hobbyGenerator.getRandomNumberInRange(10, 20);

	    	
	    		hobbyGenerator = new RandomGenerator("abcdefnopqrstuvwxyz","Hobby");
	    	 String hobby = hobbyGenerator.generateRandomString(hobbyNameLength);
     		
     		while(hobbyDetails.containsValue(hobby)) {
     			hobby = hobbyGenerator.generateRandomString(hobbyNameLength);
     		}
     		
     		hobbyDetails.put(k,hobby);
     		
	    	}
	    	
	    	HashMap<Integer,String>friendshipDescDetails = new HashMap<Integer,String>();
	    	
	    	for(int k=1;k<=100;k++)
	    	{
	    		
		    	int FriendshipDescLength = friendshipdescgenerator.getRandomNumberInRange(20, 50);

	    	
	    		hobbyGenerator = new RandomGenerator("abcdefnopqrstuvwxyz","Hobby");
	    	 String friendshipdesc = friendshipdescgenerator.generateRandomString(FriendshipDescLength);
     		
     		while(hobbyDetails.containsValue(friendshipDescDetails)) {
     			friendshipdesc = friendshipdescgenerator.generateRandomString(FriendshipDescLength);
     		}
     		
     		friendshipDescDetails.put(k,friendshipdesc);
     		
	    	}
	    	
	    	 //second file writing
		       for(int fr=1; fr<=200000;fr++ ) {
		    	   
		    	   
		        	
		        	
		    	   
		       }
	    	
	    	
	    	try {
	    	      FileWriter myWriter = new FileWriter("/Users/hamidsakhi/git/FriendsAnalytics/Mypage.csv");
	    	      FileWriter FriendWriter = new FileWriter("/Users/hamidsakhi/git/FriendsAnalytics/Friends.csv");
	    	      
	   	
	       for (int i = 1; i <= 200000; i++) {
		    	int personNameLength = personGenerator.getRandomNumberInRange(10, 20);

	        	String person_name = personGenerator.generateRandomString(personNameLength);
	        	
	        	int countryCode = nationalityGenerator.getRandomNumberInRange(1, 50);
	        	String nationality = countryDetails.get(countryCode);
	        	
	      
	        	
	        	int hobbyCode = hobbyGenerator.getRandomNumberInRange(1, 100);
	        	String hobby = hobbyDetails.get(hobbyCode);
	        	
		    	int FriendshipDescLength = friendshipdescgenerator.getRandomNumberInRange(20, 50);
 
		    	String FriendshipDesc = friendshipdescgenerator.generateRandomString(FriendshipDescLength);
 
	        	int year = randDateBetween(2008,2020);
	        	gc.set(gc.YEAR, year);
	        	
	        	int dayOfYear = randDateBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	        	gc.set(gc.DAY_OF_YEAR, dayOfYear);
	        	
	        	
	        	String FriendshipDate = gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
	     
	        	myWriter.write(i+","+person_name+","+nationality+","+countryCode+","+hobby+"\n");
	        	
	        	FriendWriter.write(i+","+FriendshipDesc+","+FriendshipDate+"\n");
	        	
	        	
	        	
	    }
	       
	       	
	       myWriter.close();
	       FriendWriter.close();
	       System.out.println("Successfully wrote to the file.");
	        } catch (IOException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
	              
	    }
	    
		
	    public static int randDateBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));
	    }

}


