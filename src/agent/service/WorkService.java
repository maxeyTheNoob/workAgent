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
       
       //��ѯ������������
       @Transactional(readOnly=true)
       public work[] search(Integer workId,
       Integer workBus,
       Integer workMajor,
       Integer workExp,
       String workDet,
       Integer workSal,
       Integer workSta){
    	   System.out.println("��ѯ������������");
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(workId, bus, workMajor, workExp, workDet, workSal, workSta);
    	   return wMapper.selectByCondition(condition);
       }
       
       //����Ա��ѯʤ�θ�λ
       @Transactional(readOnly=true)
       public work[] search(Integer empId){
    	   employee emp=empMapper.queryBycondition(empId, null, null, null, null, null)[0];
    	   work condition = new work(null, emp.getEmpMajor(), emp.getEmpExp(), null, null, 0);
    	   return wMapper.selectByCondition(condition);
       }
       
       //�޸ĸ�λ��Ϣ
       public void delete(Integer workId){
    	   System.out.println("ɾ����λ"+workId);
    	   wMapper.deleteByPrimaryKey(workId);
       }
       
       
       //������λ��Ϣ
       public void insert(
    	       Integer workBus,
    	       Integer workMajor,
    	       Integer workExp,
    	       String workDet,
    	       Integer workSal,
    	       Integer workSta){
    	   System.out.println("������λ"+workDet);
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(null, bus, workMajor, workExp, workDet, workSal, workSta);
    	   wMapper.insert(condition);
       }
       
       //���¸�λ��Ϣ
       public void update(Integer workId,
    	       Integer workBus,
    	       Integer workMajor,
    	       Integer workExp,
    	       String workDet,
    	       Integer workSal,
    	       Integer workSta) {
    	   System.out.println("���¸�λ"+workId);
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(workId, bus, workMajor, workExp, workDet, workSal, workSta);
    	   wMapper.updateByPrimaryKeySelective(condition);
	}
}
