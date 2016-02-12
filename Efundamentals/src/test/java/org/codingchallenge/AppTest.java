package org.codingchallenge;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertTrue;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;

/**
 * Unit test for simple App.
 */

public class AppTest 
    extends consoleapp
{
	@Test
	public <HashTableElement> void getSongsListenedTest(){
		
		Hashtable userdata = new Hashtable();
		userdata = consoleapp.storeDataPlay("Mo","play","Song1");
		String[] songs = new String[3];
		songs = consoleapp.returnSongsPlayed("Mo");
		Assert.assertEquals("{1=Song1}", songs[2]);
				
	}
	
	@Test 
	public <HashTableElement> void getFollowTest(){
		
		Hashtable table = new Hashtable();
		table = consoleapp.storeDataFollow("Mo","follow","Dhana");
		
		String[] follow = new String[3];
		follow = consoleapp.returnActivites("Mo","Activity");
		Assert.assertEquals("{1=Dhana}", follow[2]);
		
		
	}
	
	
	
	@Test
	public <HashTableElement> void storeDataTest(){
		
		Hashtable table = new Hashtable();
		table = consoleapp.storeDataPlay("Mo","play","Song3");	
		Assert.assertEquals("{2=Song3, 1=Song1}", table.get("Mo").toString());
			
	}
    
}
