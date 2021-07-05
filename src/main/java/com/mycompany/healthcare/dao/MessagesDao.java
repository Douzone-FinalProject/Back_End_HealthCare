package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.healthcare.dto.Messages;

@Mapper
public interface MessagesDao {
	public List<Messages> getMessageList(String staff_login_id);
	public int insertMessage(Messages messages);
	public int deleteByMessgeId(int message_id);
}
