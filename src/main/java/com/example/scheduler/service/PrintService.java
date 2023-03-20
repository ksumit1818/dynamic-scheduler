package com.example.scheduler.service;

import java.util.Date;

import org.springframework.stereotype.Service;


@Service
public class PrintService implements Runnable{
	 
	@Override
	public void run() {
		Date currentDate = new Date();
		System.out.println("running job at : "+ currentDate);
		
	}
}
