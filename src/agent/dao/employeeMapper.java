package agent.dao;


import org.apache.ibatis.annotations.Param;

import agent.pojo.employee;



public interface employeeMapper {
    void delete(Integer empId);

    void insert(employee record);
    
    void update(employee record);
    
    employee[] queryBycondition(@Param("empId") Integer empId,@Param("empName") String empName,@Param("empSex") String empSex,@Param("empExp") Integer empExp,@Param("empSta") Integer empSta,@Param("empMajor") Integer empMajor);

}