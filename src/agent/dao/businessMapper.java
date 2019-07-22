package agent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import agent.pojo.business;
import agent.pojo.employee;

public interface businessMapper {
       
	void delete(Integer busId);

	   
	void insert(business record);
	    
	    
	void update(business record);
	    
	    
	List<employee> queryBycondition(@Param("busId") Integer busId,@Param("busName") String busName,@Param("busCon") String busCon);
}