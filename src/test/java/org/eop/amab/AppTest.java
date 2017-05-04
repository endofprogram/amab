package org.eop.amab;

import java.util.Map;

public class AppTest {
	public static void main(String[] args) {
		System.out.println("\\r\\n".length());
		System.out.println("\r\n");
		System.out.println("\\r\\n");
		System.out.println(System.getProperty("line.separator").equals("\r\n"));
		System.out.println(System.getProperty("path.separator"));
		System.out.println(System.getProperty("file.separator"));
		for (Map.Entry<? super String, ? super String> entity : System.getProperties().entrySet()) {
			//System.out.println(entity.getKey() + "=" + entity.getValue());
			
		}
	}
}
