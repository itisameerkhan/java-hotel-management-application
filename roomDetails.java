package com.HotelManagementApplication;
import java.util.*;
import java.time.*;

public class roomDetails 
{
	int roomNo;
	boolean ACtype;
	boolean booked = false;
	int no_of_beds;
	roomDetails(int roomNo,boolean ACtype,boolean booked,int no_of_beds)
	{
		this.roomNo = roomNo;
		this.ACtype = ACtype;
		this.booked = booked;
		this.no_of_beds = no_of_beds;
	}
	public void displayRoomDetails()
	{
		System.out.println("---------ROOM DETAILS------------");
		System.out.println("Room Number: " + this.roomNo);
		System.out.println("AC Type: " + (this.ACtype == true ? "AC" : "NON-AC"));
		System.out.println("Booked: " + (this.booked == true ? "Booked" : "Not Booked"));
		System.out.println("Number of Beds : " + this.no_of_beds);
		System.out.println("---------------------------------");
	}
	public void displayAvailableRooms()
	{
		if(this.booked == false)
		{
			displayRoomDetails();
		}
	}
	public static boolean checkAvailability(int roomNo,ArrayList<roomDetails> roomsInfo)
	{
		for(roomDetails r: roomsInfo)
		{
			if(r.roomNo == roomNo && r.booked == true)
			{
				return false;
			}
		}
		return true;
	}
}