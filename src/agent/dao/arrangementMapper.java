package agent.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import agent.pojo.arrangement;

public interface arrangementMapper {
    void deleteByPrimaryKey(Integer arraId);
    
    void deleteByCondition(@Param("empId") Integer empId,@Param("workId") Integer workId);
    
    void insert(arrangement record);

    arrangement selectByPrimaryKey(Integer arraId);
    
    List<arrangement> selectByCondition(arrangement arra);

    void updateByPrimaryKeySelective(arrangement record);

    void updateByPrimaryKey(arrangement record);
    
    int getLastInsertId();
}