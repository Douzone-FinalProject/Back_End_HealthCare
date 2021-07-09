package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.DiagnosticResults;
import com.mycompany.healthcare.dto.ResultData;

@Mapper
public interface DiagnosticResultsDao {
	public List<ResultData> getResultDataByReceipt(String receipt_id);
	public List<ResultData> getResultDataBySpecimen(String diagnostic_specimen_number);
	public List<ResultData> getPreviousResultData(int receipt_id);
	public int insertResultData(List<ResultData> resultData);
	public int updateResultDataBySpecimen(DiagnosticResults resultInfo);
	public List<ResultData> getPreviousResultDataByNew(int receipt_id);
}
