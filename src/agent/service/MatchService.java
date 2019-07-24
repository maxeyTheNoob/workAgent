package agent.service;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agent.dao.arrangementMapper;

import agent.pojo.arrangement;
import agent.pojo.employee;
import agent.pojo.work;


@Service
@Transactional(rollbackFor=Exception.class)
public class MatchService {
      @Autowired
      private arrangementMapper arraMapper;
      @Autowired
      private WorkService workService;
      @Autowired
      private EmployeeService empService;
      @Autowired
      private MessageService messageService; 
      
      //��˾����ƥ������
      public void applyToFirm(Integer empId,Integer workId,Integer firmId){
    	  employee current= empService.search(empId, null, null, null, null, null)[0];
    	  if(current.getEmpSta()==1){
    		  System.out.println("����Ա���ڹ����У�");
    		  return;
    	  }
    	  Integer arraId = createArra(empId,workId);
    	  System.out.println("��ְ��"+empId+"��˾"+firmId+"����ƥ���λ"+workId+"������");
    	  //�½���Ϣ�����ܹ�˾��Ϊ��Ӧ��˾
    	  messageService.sendToBus(firmId, arraId,0);
      }
      
      //��Ա������ƥ������
      public void applyToEmp(Integer empId,Integer workId,Integer firmId){
    	  work current = workService.search(workId, null, null, null, null, null, null)[0];
    	  if(current.getWorkSta()!=0){
    		  System.out.println("�ø�λ��ֹͣ��Ƹ��");
    		  return;
    	  }
    	  
    	  System.out.println("��˾"+firmId+"����ְ��"+empId+"����ƥ���λ"+workId+"������");
    	  Integer arraId = createArra(empId, workId);
    	  //�½���Ϣ ��������Ϊ��ӦԱ��
    	  messageService.sendToEmp(empId, arraId,0);
      }
      
      //ȷ��ƥ��
      public void audit(boolean accept,Integer arraId){
    	  if(accept){
    		  //ͨ����ʼ�������Ų��ҳ������г�ͻ��������
              System.out.println("���ܹ�������"+arraId);
    		  startArra(arraId);
    		  arrangement arra = arraMapper.selectByPrimaryKey(arraId);
              empService.update(arra.getArraEmp().getEmpId(), null, null, null, 1, null);
              workService.update(arra.getArraWork().getWorkId(), null, null, null, null, null, 1);
    		  withdrawConflictArra(arra.getArraEmp().getEmpId(), arra.getArraWork().getWorkId());
    	  }
    	  else{
    		  System.out.println("�ܾ���������"+arraId);
    		  withdrawArra(arraId);
    	  }
      }
      
      //�����������Ų������½��Ĺ�������Id
      public int createArra(Integer empId,Integer workId){
    	  work arraWork = new work();
    	  arraWork.setWorkId(workId);
    	  employee arraEmp = new employee();
    	  arraEmp.setEmpId(empId);
          arrangement temp = new arrangement(arraEmp, arraWork, 0, null, null);
          arraMapper.insert(temp);
    	  return arraMapper.getLastInsertId();
      }
      
      //��ʼ�������ţ�������ʼ������Ϊ��ǰʱ��
      public void startArra(Integer arraId){
    	  System.out.println("��ʼ��������"+arraId);
    	  arrangement record = new arrangement(arraId, null, null, 1, new Date(System.currentTimeMillis()),null);
    	  arraMapper.updateByPrimaryKeySelective(record);
      }
      
      //�����������ţ��ܾ�ƥ��ʱ���ã�
      public void withdrawArra(Integer arraId){
    	  System.out.println("������������"+arraId);
    	  arrangement arra = arraMapper.selectByPrimaryKey(arraId);
    	  arra.setArraSta(3);
    	  arraMapper.updateByPrimaryKeySelective(arra);
    	  //��˾����ְ��Ա������Ϣ
    	  messageService.sendToBus(arra.getArraWork().getWorkBus().getBusId(), arraId,1);
    	  messageService.sendToEmp(arra.getArraEmp().getEmpId(), arraId,1);
      }
      
      //������ͻ�������ţ�����ƥ��ʱ���ã�
      public void withdrawConflictArra(Integer empId,Integer workId){
    	  System.out.println("������ͻ�Ĺ�������");
    	  //����������ø�λ��ְԱ��������֪ͨ
    	  work temp1 = new work();
    	  temp1.setWorkId(workId);
    	  arrangement con1=new arrangement();
    	  con1.setArraWork(temp1);
    	  con1.setArraSta(0);
    	  arrangement[] arraList = arraMapper.selectByCondition(con1); 
    	  for(arrangement a:arraList){		 
    		  messageService.sendToEmp(a.getArraEmp().getEmpId(), a.getArraId(),1);
    	  }
    	  
    	  //��������ļ��ְԱ�Ĺ�˾��������֪ͨ		
    	  employee emp = new employee();
    	  emp.setEmpId(empId);
    	  arrangement con2=new arrangement();
          con2.setArraEmp(emp);
    	  con2.setArraSta(0);
    	  arraList = arraMapper.selectByCondition(con2); 
    	  for(arrangement a:arraList){		 
    		  messageService.sendToBus(a.getArraWork().getWorkBus().getBusId(), a.getArraId(),1);
    	  }
    	  
    	  
    	  //��������ְ��Ա����δ��ʼ��������
    	  arraList =arraMapper.selectByCondition(con2);
    	  for(arrangement a:arraList){		 
    		  a.setArraSta(3);
    		  arraMapper.updateByPrimaryKeySelective(a);
    	  }
    	  //�����ø�λ����δ��ʼ��������
    	  arraList =arraMapper.selectByCondition(con1);
    	  for(arrangement a:arraList){		 
    		  a.setArraSta(3);
    		  arraMapper.updateByPrimaryKeySelective(a);
    	  }
      }
      
      
      //��ɹ���
      public void finishArra(Integer arraId){
    	 System.out.println("��ɹ�������"+arraId);
    	 arrangement temp = new arrangement();
    	 temp.setArraId(arraId);
    	 temp.setArraSta(2);
    	 temp.setArraEdt(new Date(System.currentTimeMillis()));
    	 arraMapper.updateByPrimaryKeySelective(temp);
      }
      
      

}

