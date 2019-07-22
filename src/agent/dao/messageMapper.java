package agent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import agent.pojo.employee;
import agent.pojo.message;

public interface messageMapper {
	void delete(Integer mesId);

    void insert(message record);
    
    void update(message record);
    
    List<message> queryBycondition(@Param("mesId") Integer mesId,@Param("mesArra") Integer mesArra,@Param("mesEmp") Integer mesEmp,@Param("mesBus") Integer mesBus,@Param("mesType") Integer mesType);
}