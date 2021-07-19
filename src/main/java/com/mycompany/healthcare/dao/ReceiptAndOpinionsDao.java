package com.mycompany.healthcare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.healthcare.dto.DiagnosticData;
import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;
import com.mycompany.healthcare.dto.StateCharts;

@Mapper
public interface ReceiptAndOpinionsDao {
	public int insertReceipt(int patient_id);
	public List<ReceiptAndOpinions> selectAllReceipt();
	public int deleteReceiptById(int receipt_id);
	public int updateReceipt(@Param("receipt_id")int receipt_id, @Param("nextState")String nextState);
	public int selectReceiptId(int patient_id);
	
	public List<ReceiptAndOpinions> selectSearchPatientIdOpinionList(String patient_id);
	public List<ReceiptAndOpinions> selectSearchDateOpinionList(String receipt_datetime);
	public List<ReceiptAndOpinions> selectSearchPatientNameOpinionList(String patient_name);
	public List<ReceiptAndOpinions> selectSearchPatientIdAndDateList(@Param("patient_id")  String patient_id, @Param("receipt_datetime")  String receipt_datetime);
	public List<ReceiptAndOpinions> selectSearchPatientIdAndNameList(@Param("patient_name") String patient_name, @Param("patient_id") String patient_id);
	public List<ReceiptAndOpinions> selectSearchPatientNameAndDateList(@Param("patient_name") String patient_name, @Param("receipt_datetime") String receipt_datetime);
	public List<ReceiptAndOpinions> selectSearchAllList(@Param("patient_id") String patient_id, @Param("patient_name") String patient_name, @Param("receipt_datetime") String receipt_datetime);
	public void updateReceiptState(int receipt_id);
	public ReceiptAndOpinions selectOpinion(int receipt_id);
	public void updateReceiptOpinion(@Param("receipt_id") int receipt_id, @Param("receipt_opinion") String receipt_opinion);
	public void updateReceiptUniqueness(@Param("receipt_id") int receipt_id, @Param("receipt_uniqueness") String receipt_uniqueness);
	public void updateTestAndReceiptState(int receipt_id);
	public int selectReadyCount();
	public int selectTreatmentCount();
	public int selectInspectionCount();
	public int selectPaymentCount();
	
	// 검사상태 환자 리스트
	public List<ReceiptAndOpinions> selectPatientStateList(@Param("type") String type, @Param("state") String state);
	public List<ReceiptAndOpinions> selectFatientOpinionsList(String patient_id);
	public void updateInsertOpinion(@Param("receipt_id") int receipt_id, @Param("receipt_opinion") String receipt_opinion, @Param("receipt_uniqueness") String receipt_uniqueness);
	public List<ReceiptAndOpinions> getReceiptDataByDate(String receipt_datetime);
	public List<ReceiptAndOpinions> getReceiptDataByName(@Param("patient_name") String patient_name,@Param("receipt_datetime") String receipt_datetime);
	public List<StateCharts> selectStateChart();
	public void updatePatientState(String receiptId);
	public void updateReceiptStates(Map<String, String> updateData);
	public void updateFinishedResultStateByReceipt(int diagnostic_results_id);
	public List<ReceiptAndOpinions> getReceiptDataByRecieptId(int receipt_id);
	public String selectReceiptState(int receiptId);
	public void updatePaymentBeforeState(int receipt_id);
	
	
	
	
	
}
