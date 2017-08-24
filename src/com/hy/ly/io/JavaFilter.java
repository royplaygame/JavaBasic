package com.hy.ly.io;

import java.io.File;
import java.io.FilenameFilter;

public class JavaFilter implements FilenameFilter{
	
	public boolean isJavaFile(String file){
		if(file.toLowerCase().endsWith(".java")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isTxtFile(String file){
		if(file.toLowerCase().endsWith(".txt")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean accept(File dir, String name) {
		return (this.isJavaFile(name)||this.isTxtFile(name));
	}

	
}
