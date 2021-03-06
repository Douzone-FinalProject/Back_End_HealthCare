package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.healthcare.dto.DiagnosticData;
import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.LabCharts;
import com.mycompany.healthcare.dto.PatientData;
import com.mycompany.healthcare.dto.Staffs;
import com.mycompany.healthcare.dto.TestStateDetail;

@Mapper
public interface DiagnosticListsDao {
	public List<Staffs> selectAllStaff();

	public void insertRequestTest(List<DiagnosticLists> keyword);

	public List<TestStateDetail> selectTestStateDetailList(int receiptId);

	public void updateStateDetail(Object updateData);

	public List<DiagnosticData> getDiagnosticDataByName(@Param("patient_name") String patient_name, @Param("receipt_datetime") String receipt_datetime);

	public List<DiagnosticData> getDiagnosticDataByDate(String receipt_datetime);

	public PatientData getPatientData(String receipt_id);
	
	public PatientData getPatientDataBySpecimen(String diagnostic_specimen_number);

	public DiagnosticData getSpecimenData(String diagnostic_specimen_number);

	public void updateFinishedResultState(int diagnostic_results_id);
	
	public void updateAllFinishedResultStateByReceipt(int diagnostic_results_id);
	public List<LabCharts> countLabPatient();

	public List<DiagnosticData> getDiagnosticDataByReceiptId(int receipt_id);

	public void updateReceiptResultStateByDiag(int diagnostic_results_id);

	public DiagnosticData getSpecimenDataByNull(int diagnostic_list_id);
	

}
