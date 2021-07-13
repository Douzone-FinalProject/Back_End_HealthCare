package com.mycompany.healthcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.healthcare.dto.Messages;

@Mapper
public interface MessagesDao {
	public List<Messages> getMessageList(String staff_login_id);
	public int insertMessage(Messages messages);
	public int deleteByMessgeId(int message_id);
	public List<Messages> getChatList(@Param("staff_id") int staff_id,@Param("staff_login_id") String staff_login_id,
			@Param("sender_login_id") String sender_login_id,@Param("senderByLogin") int senderByLogin);
}
