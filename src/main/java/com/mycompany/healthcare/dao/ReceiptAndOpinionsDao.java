package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.Staffs;

@Mapper
public interface ReceiptAndOpinionsDao {
	public List<Staffs> selectAllStaff();

	public List<ReceiptAndOpinions> selectSearchPatientIdOpinionList(String patient_id);
	public List<ReceiptAndOpinions> selectSearchDateOpinionList(String receipt_datetime);
}
