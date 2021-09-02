package com.xworkz.camera.dao;

import java.util.List;

import com.xworkz.camera.entity.CameraEntity;

public interface CameraDAO {
	int save(CameraEntity entity);
	CameraEntity readById(int primaryKey);
	void updateBrandById(int id,String brand);
	void deleteById(int id);
	void saveList(List<CameraEntity> entity);
	void deleteList(List<CameraEntity> entity);

}
