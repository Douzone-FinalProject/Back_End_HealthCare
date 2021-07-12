package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.DiagnosticImgs;
import com.mycompany.healthcare.dto.Staffs;

@Mapper
public interface DiagnosticImgsDao {

	void insertDiagnosticImg(DiagnosticImgs diagnosticImgs);
	
}
