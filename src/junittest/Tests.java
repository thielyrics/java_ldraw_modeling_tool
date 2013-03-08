package junittest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import glbrick.GLTest;
import glbrick.PartNotFoundException;
import glbrick.PartSpec;
import glbrick.brickUtilities;
import glbrick.ldrawParseTest;

import org.junit.Test;

public class Tests
{


	//put test back!!!!

	public void test()
	{
		try
		{
			GLTest.main(new String[]{});
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

	@Test
	public void allPartTest() throws FileNotFoundException
	{
		//test succeeds if it doesn't crash

		/*
		for (int i = 1; i <9000; i++){
			ldrawParseTest ldp = new ldrawParseTest();
			String temp = "";
			temp += i + ".dat";*/
		//System.out.println(temp);
		ArrayList<String> files = getFiles();
		System.out.println("test?");
		int i = 0;
		ldrawParseTest ldp = new ldrawParseTest();
		for(String s : files){

		try{
				assertTrue(ldp.lDrawTest(s));
			}
			catch (PartNotFoundException e){
			}
		System.out.println(i++);
		}
	}


public ArrayList<String> getFiles() throws FileNotFoundException{
	System.out.println("getfiles()");
	String path = "/export/home/f09/dyerjw/eclipse-work/java-ldraw-cad/ldraw/parts.txt";
	String filename = path;
	ArrayList<String> allFiles = new ArrayList<String>(7118);
	Scanner s = new Scanner(new File(filename));
	int i = 0;
	while (s.hasNextLine()) {
		allFiles.add(s.nextLine());
		
	}
	return allFiles;

}


public void test2() throws FileNotFoundException
{
	//test succeeds if it doesn't crash
	ldrawParseTest ldp = new ldrawParseTest();


	try{
		//assertTrue(ldp.lDrawTest("s/.dat"));
		System.out.println("test");
		assertTrue(ldp.lDrawTest("s/2902s01.dat"));
		System.out.println("test2");
		//assertTrue(ldp.lDrawTest("s/.dat"));

	}
	catch (PartNotFoundException e){
	}
}


@Test
public void test3() throws FileNotFoundException
{
	//test succeeds if it doesn't crash
	ldrawParseTest ldp = new ldrawParseTest();


	try{
		//assertTrue(ldp.lDrawTest("s/.dat"));
		System.out.println("test");
		assertTrue(ldp.lDrawTest("s/2902s01.dat"));
		System.out.println("test2");
		//assertTrue(ldp.lDrawTest("s/.dat"));

	}
	catch (PartNotFoundException e){
		System.out.println(e);
	}
}

}
