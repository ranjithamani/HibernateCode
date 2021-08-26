package com.xworkz.dryfruit.dao;

import com.xworkz.dryfruit.dto.DryfruitDTO;

public interface DryfruitDAO {
	int save(DryfruitDTO dto);
    DryfruitDTO readById(int pk);
}
