package com.mhj.main.locations;

import java.util.ArrayList;

public class LocationView {
	
	//전체 출력
	public void view(ArrayList<LocationDTO> ar) {
		for (LocationDTO locationDTO:ar) {
			this.view(locationDTO);
		}
	}
	
	//1개 출력
	public void view(LocationDTO locationDTO) {	
		System.out.println("Location ID    : " + locationDTO.getLocation_id());
		System.out.println("Street Address : " + locationDTO.getStreet_address());
		System.out.println("Postal Code    : " + locationDTO.getPostal_code());
		System.out.println("City           : " + locationDTO.getCity());
		System.out.println("State Province : " + locationDTO.getState_province());
		System.out.println("Country ID     : " + locationDTO.getCountry_id());
		System.out.println("==================================");
	}
	
	//메시지 출력
	public void view(String msg) {
		System.out.println(msg);
	}

}