package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.MedicinePres;
import com.mycompany.healthcare.dto.Medicines;


@Mapper
public interface MedicinePresDao {

	void insertMedicinesList(List<MedicinePres> cmlist);

	void deleteMedicinesList(int receipt_id);

	void updateMedicinesList(List<MedicinePres> handleMedicines);

}
