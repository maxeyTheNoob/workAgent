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
      
      //向公司发出匹配申请
      public void applyToFirm(Integer empId,Integer workId,Integer firmId){
    	  employee current= empService.search(empId, null, null, null, null, null)[0];
    	  if(current.getEmpSta()==1){
    		  System.out.println("该人员正在工作中！");
    		  return;
    	  }
    	  Integer arraId = createArra(empId,workId);
    	  System.out.println("求职者"+empId+"向公司"+firmId+"发出匹配岗位"+workId+"的申请");
    	  //新建消息，接受公司设为对应公司
    	  messageService.sendToBus(firmId, arraId,0);
      }
      
      //向员工发出匹配申请
      public void applyToEmp(Integer empId,Integer workId,Integer firmId){
    	  work current = workService.search(workId, null, null, null, null, null, null)[0];
    	  if(current.getWorkSta()!=0){
    		  System.out.println("该岗位已停止招聘！");
    		  return;
    	  }
    	  
    	  System.out.println("公司"+firmId+"向求职者"+empId+"发出匹配岗位"+workId+"的申请");
    	  Integer arraId = createArra(empId, workId);
    	  //新建消息 接受人设为对应员工
    	  messageService.sendToEmp(empId, arraId,0);
      }
      
      //确认匹配
      public void audit(boolean accept,Integer arraId){
    	  if(accept){
    		  //通过则开始工作安排并且撤销所有冲突工作安排
              System.out.println("接受工作安排"+arraId);
    		  startArra(arraId);
    		  arrangement arra = arraMapper.selectByPrimaryKey(arraId);
              empService.update(arra.getArraEmp().getEmpId(), null, null, null, 1, null);
              workService.update(arra.getArraWork().getWorkId(), null, null, null, null, null, 1);
    		  withdrawConflictArra(arra.getArraEmp().getEmpId(), arra.getArraWork().getWorkId());
    	  }
    	  else{
    		  System.out.println("拒绝工作安排"+arraId);
    		  withdrawArra(arraId);
    	  }
      }
      
      //创建工作安排并返回新建的工作安排Id
      public int createArra(Integer empId,Integer workId){
    	  work arraWork = new work();
    	  arraWork.setWorkId(workId);
    	  employee arraEmp = new employee();
    	  arraEmp.setEmpId(empId);
          arrangement temp = new arrangement(arraEmp, arraWork, 0, null, null);
          arraMapper.insert(temp);
    	  return arraMapper.getLastInsertId();
      }
      
      //开始工作安排，并将开始日期设为当前时间
      public void startArra(Integer arraId){
    	  System.out.println("开始工作安排"+arraId);
    	  arrangement record = new arrangement(arraId, null, null, 1, new Date(System.currentTimeMillis()),null);
    	  arraMapper.updateByPrimaryKeySelective(record);
      }
      
      //撤销工作安排（拒绝匹配时调用）
      public void withdrawArra(Integer arraId){
    	  System.out.println("撤销工作安排"+arraId);
    	  arrangement arra = arraMapper.selectByPrimaryKey(arraId);
    	  arra.setArraSta(3);
    	  arraMapper.updateByPrimaryKeySelective(arra);
    	  //向公司和求职人员发送消息
    	  messageService.sendToBus(arra.getArraWork().getWorkBus().getBusId(), arraId,1);
    	  messageService.sendToEmp(arra.getArraEmp().getEmpId(), arraId,1);
      }
      
      //撤销冲突工作安排（接受匹配时调用）
      public void withdrawConflictArra(Integer empId,Integer workId){
    	  System.out.println("撤销冲突的工作安排");
    	  //向所有申请该岗位的职员发出撤销通知
    	  work temp1 = new work();
    	  temp1.setWorkId(workId);
    	  arrangement con1=new arrangement();
    	  con1.setArraWork(temp1);
    	  con1.setArraSta(0);
    	  arrangement[] arraList = arraMapper.selectByCondition(con1); 
    	  for(arrangement a:arraList){		 
    		  messageService.sendToEmp(a.getArraEmp().getEmpId(), a.getArraId(),1);
    	  }
    	  
    	  //向所有招募该职员的公司发出撤销通知		
    	  employee emp = new employee();
    	  emp.setEmpId(empId);
    	  arrangement con2=new arrangement();
          con2.setArraEmp(emp);
    	  con2.setArraSta(0);
    	  arraList = arraMapper.selectByCondition(con2); 
    	  for(arrangement a:arraList){		 
    		  messageService.sendToBus(a.getArraWork().getWorkBus().getBusId(), a.getArraId(),1);
    	  }
    	  
    	  
    	  //撤销该求职人员其他未开始工作安排
    	  arraList =arraMapper.selectByCondition(con2);
    	  for(arrangement a:arraList){		 
    		  a.setArraSta(3);
    		  arraMapper.updateByPrimaryKeySelective(a);
    	  }
    	  //撤销该岗位其他未开始工作安排
    	  arraList =arraMapper.selectByCondition(con1);
    	  for(arrangement a:arraList){		 
    		  a.setArraSta(3);
    		  arraMapper.updateByPrimaryKeySelective(a);
    	  }
      }
      
      
      //完成工作
      public void finishArra(Integer arraId){
    	 System.out.println("完成工作安排"+arraId);
    	 arrangement temp = new arrangement();
    	 temp.setArraId(arraId);
    	 temp.setArraSta(2);
    	 temp.setArraEdt(new Date(System.currentTimeMillis()));
    	 arraMapper.updateByPrimaryKeySelective(temp);
      }
      
      

}

