package com.mhj.main.locations;

import java.util.Scanner;

public class LocationInput {
	
	private Scanner sc;
	
	public LocationInput() {
		sc = new Scanner(System.in);
	}
	
	//수정
	public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("수정할 지역의 번호를 입력해 주세요.");
		locationDTO.setCountry_id(sc.next());
		
		System.out.println("수정할 지역의 도시 이름을 입력하세요.");
		locationDTO.setCity(sc.next());
		System.out.println("수정할 지역의 국가 번호를 입력하세요.");
		locationDTO.setCountry_id(sc.next());
		
		return locationDTO;
	}
	
	//추가
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("추가할 지역의 거리 번호를 입력하세요.");
		locationDTO.setStreet_address(sc.next());
		System.out.println("추가할 지역의 우편 번호를 입력하세요.");
		locationDTO.setPostal_code(sc.next());
		System.out.println("추가할 지역의 시를 입력하세요.");
		locationDTO.setCity(sc.next());
		System.out.println("추가할 지역의 주를 입력하세요.");
		locationDTO.setState_province(sc.next());
		System.out.println("추가할 지역의 국가 번호를 입력하세요.");
		locationDTO.setCountry_id(sc.next());
		
		return locationDTO;
		
	}
	
	//삭제
	public LocationDTO deleteDate() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("삭제할 지역의 ID를 입력하세요.");
		locationDTO.setLocation_id(sc.nextInt());
		
		return locationDTO;
	}

}
