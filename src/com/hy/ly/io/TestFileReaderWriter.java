package com.hy.ly.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

public class TestFileReaderWriter {

	@Test
	public void testFileReader() throws FileNotFoundException {
		File file = new File("D:\\temp\\tt.doc");

		FileReader fr = new FileReader(file);
	}

}
