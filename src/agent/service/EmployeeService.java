package agent.service;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agent.dao.arrangementMapper;
import agent.dao.employeeMapper;
import agent.dao.workMapper;
import agent.pojo.arrangement;
import agent.pojo.employee;
import agent.pojo.work;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {
	@Autowired
	employeeMapper empMapper;
	@Autowired
	arrangementMapper arraMapper;
	@Autowired
	workMapper wMapper;
	
    
	//条件查找
	public employee[] search(Integer empId, String empName, String empSex, Integer empExp, Integer empSta,
			Integer empMajor) {
		System.out.println("查询求职人员信息");
		return empMapper.queryBycondition(empId, empName, empSex, empExp, empSta, empMajor);
	}
	
	//按工作条件查询符合人员
	public employee[] searchByWork(Integer workId){
		System.out.println("按工作"+workId+"的条件查找胜任求职人员");
		work w=wMapper.selectByPrimaryKey(workId);
		return empMapper.queryBycondition(null, null, null, w.getWorkExp(), 0, w.getWorkMajor());
	}
	
	//删除人员信息
	public void delete(Integer empId){
		System.out.println("删除求职人员"+empId);
		empMapper.delete(empId);
	}
	
	//修改求职人员信息
	public void update(Integer empId, String empName, String empSex, Integer empExp, Integer empSta,
			Integer empMajor){
		System.out.println("修改求职人员"+empId);
		employee record = new employee(empId, empName, empSex, empExp, empSta, empMajor);
		empMapper.update(record);
	}
	
	//新增求职人员信息
	public void add(String empName, String empSex, Integer empExp, Integer empSta,
			Integer empMajor){
		System.out.println("新增求职人员："+empName);
		employee record = new employee(null, empName, empSex, empExp, empSta, empMajor);
		empMapper.insert(record);
	}
	
	//查看过去工作安排
	public arrangement[] searchOldArra(Integer empId){
		System.out.println("查看求职人员"+empId+"过去工作记录");
		employee arraEmp = new employee();
		arraEmp.setEmpId(empId);
		arrangement con = new arrangement(arraEmp, null, 2, null, null);
		return arraMapper.selectByCondition(con);
	}
	
	//查看通过工作安排
	public arrangement[] searchPassArra(Integer empId){
		System.out.println("查看求职人员"+empId+"通过的工作记录");
		employee arraEmp = new employee();
		arraEmp.setEmpId(empId);
		arrangement con = new arrangement(arraEmp, null, 1, null, null);
		return arraMapper.selectByCondition(con);
	}

}
