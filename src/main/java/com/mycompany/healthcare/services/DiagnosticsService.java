package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.SearchsDao;
import com.mycompany.healthcare.dto.Searchs;

@Service
public class DiagnosticsService {
	@Autowired
	private SearchsDao searchsDao;

	public List<Searchs> getSearchList(String symptom_name) {
		List<Searchs> searchList = searchsDao.selectSearchList(symptom_name);
		return searchList;
	}

}