package agent.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agent.dao.messageMapper;
import agent.pojo.arrangement;
import agent.pojo.business;
import agent.pojo.employee;
import agent.pojo.message;

@Service
@Transactional(rollbackFor=Exception.class)
//0类通知为匹配申请  //1类通知为撤销通知
public class MessageService {
       @Autowired
       messageMapper mMapper;
       
       //搜索员工收到的通知
       @Transactional(readOnly=true)
       public message[] empSearchMes(Integer empId,Integer type){
    	   System.out.println("搜索求职人员"+empId+"收到的"+type+"类型通知");
    	   return mMapper.queryBycondition(null, null, empId, null, type);
       }
       
       //搜索公司收到的通知
       @Transactional(readOnly=true)
       public message[] busSearchMes(Integer busId,Integer type){
    	   System.out.println("搜索公司"+busId+"收到的"+type+"类型通知");
    	   return mMapper.queryBycondition(null, null, null, busId, type);
       }
       
       //向人员发出通知
       public void sendToEmp(Integer empId,Integer arraId,Integer type){
    	   System.out.println("向求职人员"+empId+"发出关于工作安排"+arraId+"的"+type+"类型通知");
    	   arrangement mesArra = new arrangement();
    	   mesArra.setArraId(arraId);
    	   message temp = new message(null, mesArra, empId, null,type);
    	   mMapper.insert(temp);
       }
       
       
       //向公司发出通知
       public void sendToBus(Integer busId,Integer arraId,Integer type){
    	   System.out.println("向公司"+busId+"发出关于工作安排"+arraId+"的"+type+"类型通知");
    	   arrangement mesArra = new arrangement();
    	   mesArra.setArraId(arraId);
    	   business mesBus = new business();
    	   mesBus.setBusId(busId);
    	   message temp = new message(null, mesArra, null, mesBus, type);
    	   mMapper.insert(temp);
       }
       

}
