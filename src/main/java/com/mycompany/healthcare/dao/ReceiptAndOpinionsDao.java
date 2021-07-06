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
	public List<ReceiptAndOpinions> selectSearchPatientNameOpinionList(String patient_name);
	public List<ReceiptAndOpinions> selectSearchPatientIdAndDateList(@Param("patient_id")  String patient_id, @Param("receipt_datetime")  String receipt_datetime);
	public List<ReceiptAndOpinions> selectSearchPatientIdAndNameList(@Param("patient_name") String patient_name, @Param("patient_id") String patient_id);
	public List<ReceiptAndOpinions> selectSearchPatientNameAndDateList(@Param("patient_name") String patient_name, @Param("receipt_datetime") String receipt_datetime);
	public List<ReceiptAndOpinions> selectSearchAllList(@Param("patient_id") String patient_id, @Param("patient_name") String patient_name, @Param("receipt_datetime") String receipt_datetime);
	public void updateReceiptState(int receipt_id);
	public List<ReceiptAndOpinions> selectFatientOpinionsList(String patient_id);
	public void updateInsertOpinion(@Param("receipt_id") int receipt_id, @Param("receipt_opinion") String receipt_opinion, @Param("receipt_uniqueness") String receipt_uniqueness);
	

}
