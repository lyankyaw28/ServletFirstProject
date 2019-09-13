package test;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		File file = new File(classloader.getResource("Jillian-Facebook-2-1-696x366.jpg").getFile());
		System.out.println(file.getAbsolutePath());
	}
}
