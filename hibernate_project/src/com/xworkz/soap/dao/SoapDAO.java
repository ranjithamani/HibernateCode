package com.xworkz.soap.dao;

import com.xworkz.soap.dto.SoapDTO;

public interface SoapDAO {
	
	int save(SoapDTO dto);
	SoapDTO readById(int primaryKey);

}
