package com.mycompany.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.healthcare.dao.MessagesDao;
import com.mycompany.healthcare.dao.PatientsDao;
import com.mycompany.healthcare.dao.StaffsDao;
import com.mycompany.healthcare.dto.Messages;
import com.mycompany.healthcare.dto.Patients;
import com.mycompany.healthcare.dto.Staffs;

@Service
public class MessageService {

	@Autowired
	private MessagesDao messagesDao;
	@Autowired
	private StaffsDao staffsDao;
	
	public List<Messages> getMessageList(String staff_login_id) {
		return messagesDao.getMessageList(staff_login_id);
	}

	public boolean addMessage(Messages messages) {
		boolean result = true;
		int row = messagesDao.insertMessage(messages);
		if (row != 1) {
			result = false;
		}
		return result;
	}

	public List<Staffs> getStaffList(String staff_login_id) {
		int hospital_id = staffsDao.getHospitalIdByLoginId(staff_login_id);
		return staffsDao.getStaffListByHospitalId(hospital_id);
	}

	public boolean deleteMessage(int message_id) {
		int row = messagesDao.deleteByMessgeId(message_id);
		
		if(row != 1) {
			return false;
		} else {
			return true;
		}
	}

	public List<Messages> getChatList(int staff_id, String staff_login_id) {
		String sender_login_id = staffsDao.getSenderLoginId(staff_id);
		int senderByLogin = staffsDao.getSenderByLogin(staff_login_id);
		return messagesDao.getChatList(staff_id, staff_login_id, sender_login_id, senderByLogin);
	}

	public int getStaffId(String staff_login_id) {
		return staffsDao.getStaffId(staff_login_id);
	}

	public String getStaffLoginId(int staff_id) {
		return staffsDao.getSenderLoginId(staff_id);
	}
	
}
