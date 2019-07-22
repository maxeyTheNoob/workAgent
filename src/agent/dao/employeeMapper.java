package agent.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import agent.pojo.employee;



public interface employeeMapper {
    void delete(Integer empId);

    void insert(employee record);
    
    void update(employee record);
    
    List<employee> queryBycondition(@Param("empId") Integer empId,@Param("empName") String empName,@Param("empSex") String empSex,@Param("empExp") Integer empExp,@Param("empSta") Integer empSta,@Param("empMajor") Integer empMajor);

}