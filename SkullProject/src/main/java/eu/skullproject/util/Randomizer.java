package eu.skullproject.util;

import java.util.Random;

import eu.skullproject.events.ChatMSG;

public class Randomizer {
	public static String runWelcome() {
        String [] arr = {"Welcome!","Whalecum!", "WELCOME! :D"};
        Random random = new Random();

        int select = random.nextInt(arr.length); 
        return arr[select]; 
   }
}
