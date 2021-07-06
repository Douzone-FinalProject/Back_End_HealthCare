package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.healthcare.dto.ReceiptAndOpinions;

@Mapper
public interface ReceiptAndOpinionsDao {
	public int insertReceipt(ReceiptAndOpinions receipt);
	public List<ReceiptAndOpinions> selectAllReceipt();
	public int deleteReceiptById(int receipt_id);
	public int updateReceipt(int patient_id);

	public List<ReceiptAndOpinions> selectSearchPatientIdOpinionList(String patient_id);
	public List<ReceiptAndOpinions> selectSearchDateOpinionList(String receipt_datetime);
	public void updateReceiptState(int receipt_id);
	
	// 검사상태 환자 리스트
	public List<ReceiptAndOpinions> selectPatientStateList(@Param("type") String type, @Param("state") String state);
}
