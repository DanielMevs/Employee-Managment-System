package com.cognixia.jump.project.ems;
import java.io.File;
import java.io.FilenameFilter;

public interface Filtered {
	public static File[] finder(String dirName) {
		   File dir = new File(dirName);

	        return dir.listFiles(new FilenameFilter() { 
	                 public boolean accept(File dir, String filename)
	                      { return filename.endsWith(".txt"); }
	        } );
	}
	public static int getSubstrLength(String filePath) {
		int length = filePath.length();
		while(filePath.charAt(length-1) != '/') {
			length--;
		}
		return length;
		
	}
}
