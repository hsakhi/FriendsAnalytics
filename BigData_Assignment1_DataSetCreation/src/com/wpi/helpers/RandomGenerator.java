package com.wpi.helpers;

import java.security.SecureRandom;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomGenerator {
	
	private String characters_lower;
	private String characters_upper;
	private String random_string;
	private int year; 

	
	private static final SecureRandom random = new SecureRandom();
	
	public RandomGenerator(String characters_lower,String type) {
		
		this.characters_lower = characters_lower;
		this.characters_upper = characters_lower.toUpperCase();
		
		if(type.equals("Person")) {
			
			random_string = this.characters_lower + this.characters_upper;
			
		}
		else if(type.equals("Nationality")) {
			
			
			random_string = characters_upper;
			
		}
		else if(type.equals("Hobby")) {
			
			
			random_string = characters_lower;
		}
		
		else if(type.equals("FriendshipDesc")) {
			
			random_string = characters_lower;
		}
		
		
	}
	
	public int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
    
	
//	public static int randDateBetween(int start, int end) {
//		
//        return start + (int)Math.round(Math.random() * (end - start));
//        
//    }
	

    public String generateRandomString(int length) {
    	
    	
    	
  if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

			
            int rndCharAt = random.nextInt(random_string.length());
            char rndChar = random_string.charAt(rndCharAt);

            

            sb.append(rndChar);

        }

        return sb.toString();
    }


}