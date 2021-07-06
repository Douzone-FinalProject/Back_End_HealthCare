package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.DiagnosticLists;
import com.mycompany.healthcare.dto.Staffs;
import com.mycompany.healthcare.dto.TestStateDetail;

@Mapper
public interface DiagnosticListsDao {
	public List<Staffs> selectAllStaff();

	public void insertRequestTest(List<DiagnosticLists> keyword);

	public List<TestStateDetail> selectTestStateDetailLIst(int receiptId);

	public void updateStateDetail(Object updateData);

}
