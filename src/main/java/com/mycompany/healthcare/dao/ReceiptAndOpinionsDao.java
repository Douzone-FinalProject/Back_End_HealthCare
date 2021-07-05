
package com.mycompany.healthcare.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mycompany.healthcare.dto.ReceiptAndOpinions;


@Mapper
public interface ReceiptAndOpinionsDao {
	public int insertReceipt(ReceiptAndOpinions receipt);
	public List<ReceiptAndOpinions> selectAllReceipt();
	public int deleteReceiptById(int receipt_id);
	public int updateReceipt(int patient_id);
}
