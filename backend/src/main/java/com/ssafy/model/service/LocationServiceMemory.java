package com.ssafy.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.GugunAddressDAO;
import com.ssafy.model.dao.GugunCodeDAO;
import com.ssafy.model.dao.SidoCodeDAO;
import com.ssafy.model.dto.GugunAddress;
import com.ssafy.model.dto.GugunCode;
import com.ssafy.model.dto.SidoCode;

@Service
public class LocationServiceMemory implements LocationService {

	private SidoCodeDAO sidoCodeDAO;
	
	private GugunCodeDAO gugunCodeDAO;
	
	private GugunAddressDAO gugunAddressDAO;
	
	private final List<GugunAddress> gugunAddressList;
	private final List<SidoCode> sidoCodeList;
	private final List<GugunCode> gugunCodeList;
	
	public LocationServiceMemory(SidoCodeDAO sidoCodeDAO, GugunCodeDAO gugunCodeDAO, GugunAddressDAO gugunAddressDAO) {
		this.sidoCodeDAO = sidoCodeDAO;
		this.gugunCodeDAO = gugunCodeDAO;
		this.gugunAddressDAO = gugunAddressDAO;
		this.gugunAddressList = gugunAddressDAO.getGugunAddressAll();
		this.sidoCodeList = sidoCodeDAO.readAll();
		this.gugunCodeList = gugunCodeDAO.getGugunCodeAll();
	}
	
	// gugunAddressList
	@Override
	public GugunAddress getGugunAddressByGugunCode(String gugunCode) {
		int low = -1, high = this.gugunAddressList.size();
		
		while(low + 1 < high) {
			int mid = (low + high) >>1;
			
			
			int comp =gugunAddressList.get(mid).getGugunCode().compareTo(gugunCode);
			if(comp == 0) return gugunAddressList.get(mid);
			else if(comp > 0) high = mid;
			else low = mid;
		}
		return null;
	}
	
	// sidoCodeList
	@Override
	public List<SidoCode> getSidoCodeAll() {
		return this.sidoCodeList;
	}

	// gugunCodeList
	@Override
	public List<GugunCode> getGugunCodeAllBySidoCode(String sidoCode) {
		int start = -1, end = -1;
		
		int low = -1, high = this.gugunCodeList.size();
		
		// lower_bound
		while(low +1 < high) {
			int mid = (low + high) >>1;
			
			GugunCode t = this.gugunCodeList.get(mid); 
			
			if(t.getGugunCode().compareTo(sidoCode) >=0)  high = mid;
			else low = mid;
		}
		
		// 없으면 비어있는 List 
		if(high == this.gugunCodeList.size()) return new ArrayList<GugunCode>();
		start = high;
		
		String upperSidoCode = Integer.toString(Integer.parseInt(sidoCode.substring(0, 2))+1) + "00000000";
		
		// upper_bound
		low = -1; high = this.gugunCodeList.size();
		while(low +1 < high) {
			int mid = (low + high) >>1;
			
			GugunCode t = this.gugunCodeList.get(mid); 
			
			if(t.getGugunCode().compareTo(upperSidoCode) >=0)  high = mid;
			else low = mid;
		}
		end = high;
		
		return  this.gugunCodeList.subList(start, end);
	}

}
