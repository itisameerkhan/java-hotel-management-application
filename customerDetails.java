package com.HotelManagementApplication;

import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class customerDetails 
{
	private int customer_id;
	private int roomNo;
	private String customer_name;
	private Date booked_date;
	private Date unpacking_date;
	private int no_of_days;
	
	customerDetails(int customer_id,int roomNo,String customer_name,Date booked_date,Date unpacking_date,ArrayList<roomDetails> roomInfos)
	{
		this.customer_id = customer_id;
		this.roomNo = roomNo;
		this.customer_name = customer_name;
		this.booked_date = booked_date;
		this.unpacking_date = unpacking_date;
		for(roomDetails r: roomInfos)
		{
			if(r.roomNo == this.roomNo)
			{
				r.booked = true;
			}
		}
		
	}
	public void displayCustomerDetails()
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//no_of_days = ChronoUnit.DAYS.between(booked_date, unpacking_date);
		
		System.out.println("-----------CUSTOMER DETAILS------------");
		System.out.println("Customer ID : " + this.customer_id);
		System.out.println("Room Number: " + this.roomNo);
		System.out.println("Customer Name: " + this.customer_name);
		System.out.println("Booked Date: " + dateFormat.format(booked_date));
		System.out.println("Unpacking Date: " + dateFormat.format(unpacking_date));
		System.out.println(booked_date);
	}
	public void CancelReservation()
	{
		
	}
}