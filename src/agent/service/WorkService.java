package agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agent.dao.employeeMapper;
import agent.dao.workMapper;
import agent.pojo.business;
import agent.pojo.employee;
import agent.pojo.work;

@Service
@Transactional(rollbackFor=Exception.class)
public class WorkService {
       @Autowired
       private workMapper wMapper;
       @Autowired
       private employeeMapper empMapper;
       
       //查询满足条件工作
       @Transactional(readOnly=true)
       public work[] search(Integer workId,
       Integer workBus,
       Integer workMajor,
       Integer workExp,
       String workDet,
       Integer workSal,
       Integer workSta){
    	   System.out.println("查询满足条件工作");
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(workId, bus, workMajor, workExp, workDet, workSal, workSta);
    	   return wMapper.selectByCondition(condition);
       }
       
       //按人员查询胜任岗位
       @Transactional(readOnly=true)
       public work[] search(Integer empId){
    	   employee emp=empMapper.queryBycondition(empId, null, null, null, null, null)[0];
    	   work condition = new work(null, emp.getEmpMajor(), emp.getEmpExp(), null, null, 0);
    	   return wMapper.selectByCondition(condition);
       }
       
       //修改岗位信息
       public void delete(Integer workId){
    	   System.out.println("删除岗位"+workId);
    	   wMapper.deleteByPrimaryKey(workId);
       }
       
       
       //新增岗位信息
       public void insert(
    	       Integer workBus,
    	       Integer workMajor,
    	       Integer workExp,
    	       String workDet,
    	       Integer workSal,
    	       Integer workSta){
    	   System.out.println("新增岗位"+workDet);
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(null, bus, workMajor, workExp, workDet, workSal, workSta);
    	   wMapper.insert(condition);
       }
       
       //更新岗位信息
       public void update(Integer workId,
    	       Integer workBus,
    	       Integer workMajor,
    	       Integer workExp,
    	       String workDet,
    	       Integer workSal,
    	       Integer workSta) {
    	   System.out.println("更新岗位"+workId);
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(workId, bus, workMajor, workExp, workDet, workSal, workSta);
    	   wMapper.updateByPrimaryKeySelective(condition);
	}
}
