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
	
    
	//��������
	public employee[] search(Integer empId, String empName, String empSex, Integer empExp, Integer empSta,
			Integer empMajor) {
		System.out.println("��ѯ��ְ��Ա��Ϣ");
		return empMapper.queryBycondition(empId, empName, empSex, empExp, empSta, empMajor);
	}
	
	//������������ѯ������Ա
	public employee[] searchByWork(Integer workId){
		System.out.println("������"+workId+"����������ʤ����ְ��Ա");
		work w=wMapper.selectByPrimaryKey(workId);
		return empMapper.queryBycondition(null, null, null, w.getWorkExp(), 0, w.getWorkMajor());
	}
	
	//ɾ����Ա��Ϣ
	public void delete(Integer empId){
		System.out.println("ɾ����ְ��Ա"+empId);
		empMapper.delete(empId);
	}
	
	//�޸���ְ��Ա��Ϣ
	public void update(Integer empId, String empName, String empSex, Integer empExp, Integer empSta,
			Integer empMajor){
		System.out.println("�޸���ְ��Ա"+empId);
		employee record = new employee(empId, empName, empSex, empExp, empSta, empMajor);
		empMapper.update(record);
	}
	
	//������ְ��Ա��Ϣ
	public void add(String empName, String empSex, Integer empExp, Integer empSta,
			Integer empMajor){
		System.out.println("������ְ��Ա��"+empName);
		employee record = new employee(null, empName, empSex, empExp, empSta, empMajor);
		empMapper.insert(record);
	}
	
	//�鿴��ȥ��������
	public arrangement[] searchOldArra(Integer empId){
		System.out.println("�鿴��ְ��Ա"+empId+"��ȥ������¼");
		employee arraEmp = new employee();
		arraEmp.setEmpId(empId);
		arrangement con = new arrangement(arraEmp, null, 2, null, null);
		return arraMapper.selectByCondition(con);
	}
	
	//�鿴ͨ����������
	public arrangement[] searchPassArra(Integer empId){
		System.out.println("�鿴��ְ��Ա"+empId+"ͨ���Ĺ�����¼");
		employee arraEmp = new employee();
		arraEmp.setEmpId(empId);
		arrangement con = new arrangement(arraEmp, null, 1, null, null);
		return arraMapper.selectByCondition(con);
	}

}
