package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.ResultData;

@Mapper
public interface DiagnosticResultsDao {
	public List<ResultData> getResultDataByReceipt(String receipt_id);
	public List<ResultData> getResultDataBySpecimen(String diagnostic_specimen_number);
	public int updateResultDataBySpecimen(String result);
}
