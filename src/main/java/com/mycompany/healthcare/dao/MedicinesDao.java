package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.Medicines;
import com.mycompany.healthcare.dto.Staffs;

@Mapper
public interface MedicinesDao {
	public List<Medicines> searchMedicines(String keyword);

	public List<Medicines>  selectReadReceiptMedicines(int receipt_id);
}
