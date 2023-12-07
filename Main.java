package com.HotelManagementApplication;

import java.util.*;
import java.text.*;
import java.time.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		ArrayList<roomDetails> roomInfos = new ArrayList<>();
		roomInfos.add(new roomDetails(101,true,false,4));
		roomInfos.add(new roomDetails(102,true,false,4));
		roomInfos.add(new roomDetails(103,false,false,2));
		roomInfos.add(new roomDetails(104,true,false,2));
		roomInfos.add(new roomDetails(105,true,false,4));
		roomInfos.add(new roomDetails(106,false,false,2));
		roomInfos.add(new roomDetails(107,false,false,4));
		roomInfos.add(new roomDetails(108,true,false,2));
		roomInfos.add(new roomDetails(109,false,false,2));
		roomInfos.add(new roomDetails(110,true,false,4));
		
		
		ArrayList<customerDetails> customerInfo = new ArrayList<>();
		
		System.out.println("-----------WELCOME TO OYO HOTEL BOOKING----------");
		
		int choice = 1;
		while(choice != 6)
		{
			System.out.println("-------------------------------------------------");
			System.out.println("1. Display Available Rooms");
			System.out.println("2. Display Booked Customers");
			System.out.println("3. Display All Rooms");
			System.out.println("4. Book Rooms");
			System.out.println("5. Cancel Reservation");
			System.out.println("6. Exit");
			System.out.println("-------------------------------------------------");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1: for(roomDetails r: roomInfos) r.displayAvailableRooms(); break;
			case 2:for(customerDetails c: customerInfo) c.displayCustomerDetails(); break;
			case 3: for(roomDetails r: roomInfos) r.displayRoomDetails(); break;
			case 4:
				System.out.print("Enter the Customer Name: ");
				String customer_name = sc.next();
				System.out.print("Enter the Customer Id: ");
				int customer_id = sc.nextInt();
				System.out.print("Enter the Room Number: ");
				int roomNo = sc.nextInt();
				if(roomDetails.checkAvailability(roomNo, roomInfos) == true) 
				{
					sc.nextLine();
					System.out.print("Enter the Booking Date(dd/MM/yyyy): ");
					String inputDate = sc.next();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date bookingDate = null;
					try 
					{
						bookingDate = dateFormat.parse(inputDate);
					}
					catch(Exception e) {}
					System.out.print("Enter the unpacking date: ");
					inputDate = sc.next();
					Date unpacking_date = null;
					try
					{
						unpacking_date = dateFormat.parse(inputDate);
					}
					catch(Exception e) {}
					customerInfo.add(new customerDetails(customer_id,roomNo,customer_name,bookingDate,unpacking_date,roomInfos));
					System.out.println("Room Booked Successfully");
				}
				else System.out.println("Room UnAvailable");
			}
		}
		System.out.println("Thanks for Visiting us !");
	}
}