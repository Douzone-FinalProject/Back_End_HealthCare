package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.MedicinePres;


@Mapper
public interface MedicinePresDao {

	void insertMedicinesList(List<MedicinePres> cmlist);

}
