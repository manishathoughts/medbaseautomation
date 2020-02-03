package com.medbase.test;

import java.io.File;

import org.junit.Test;

public class FileTest {
	
	@Test
	public void deletefile() {
		
		
		File f= new File("C:\\Users\\Viswa\\Downloads\\absences.csv");
		
		if(f.exists())
			
			f.delete();
		
		
	}

}
