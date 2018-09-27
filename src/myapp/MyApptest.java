package myapp;

import org.junit.jupiter.api.Test;

class MyApptest {

	@Test
	void test() {
		Myapp a0 = new Myapp(new String[] {"-n","10000000" ,"-r" , "10"});
		Myapp a1 = new Myapp(new String[] {"-n","100" ,"-r" , "100"});
		Myapp a2 = new Myapp(new String[] {"-n" ,"-r" , "100"});
		Myapp a3 = new Myapp(new String[] {"-e","d:/Exercises.txt" ,"-a" , "D:\\Answer.txt"});
		Myapp a9 = new Myapp(new String[] {"-e","././testFile/Exercises.txt" ,"-a" , "././testFile/Answer.txt"});
		Myapp a4 = new Myapp(new String[] {"-e","123" ,"-a" , "D:\\Answer.txt"});
		Myapp a10 = new Myapp(new String[] {"-e","d:/Exercises.txt" ,"-a" , "123"});
		Myapp a5 = new Myapp(new String[] {"-e","123" ,"-a"});
		Myapp a6 = new Myapp(new String[] {"-e"});
		Myapp a7 = new Myapp(new String[] {"-n"});
		Myapp a8 = new Myapp(new String[] {"-r"});
	}

}
