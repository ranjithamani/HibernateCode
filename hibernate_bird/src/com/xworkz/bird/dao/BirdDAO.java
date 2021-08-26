package com.xworkz.bird.dao;

import com.xworkz.bird.entity.BirdEntity;

public interface BirdDAO {
	int save(BirdEntity entity);
	BirdEntity readById(int primaryKey);
	}
