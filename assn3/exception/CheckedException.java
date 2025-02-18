package com.assn3.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException implements Runnable{
	
	public void run() {
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		//IO exception
		try {
			FileReader fileReader=new FileReader("anil.java");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//File Not found Exception
		try {
			FileInputStream file=new FileInputStream("Anil.java");
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		//InetruptException
		Thread thread=new Thread(new CheckedException());
		thread.start();
		thread.interrupt();
		
		
	}

}
