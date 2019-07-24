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
//0��֪ͨΪƥ������  //1��֪ͨΪ����֪ͨ
public class MessageService {
       @Autowired
       messageMapper mMapper;
       
       //����Ա���յ���֪ͨ
       @Transactional(readOnly=true)
       public message[] empSearchMes(Integer empId,Integer type){
    	   System.out.println("������ְ��Ա"+empId+"�յ���"+type+"����֪ͨ");
    	   return mMapper.queryBycondition(null, null, empId, null, type);
       }
       
       //������˾�յ���֪ͨ
       @Transactional(readOnly=true)
       public message[] busSearchMes(Integer busId,Integer type){
    	   System.out.println("������˾"+busId+"�յ���"+type+"����֪ͨ");
    	   return mMapper.queryBycondition(null, null, null, busId, type);
       }
       
       //����Ա����֪ͨ
       public void sendToEmp(Integer empId,Integer arraId,Integer type){
    	   System.out.println("����ְ��Ա"+empId+"�������ڹ�������"+arraId+"��"+type+"����֪ͨ");
    	   arrangement mesArra = new arrangement();
    	   mesArra.setArraId(arraId);
    	   message temp = new message(null, mesArra, empId, null,type);
    	   mMapper.insert(temp);
       }
       
       
       //��˾����֪ͨ
       public void sendToBus(Integer busId,Integer arraId,Integer type){
    	   System.out.println("��˾"+busId+"�������ڹ�������"+arraId+"��"+type+"����֪ͨ");
    	   arrangement mesArra = new arrangement();
    	   mesArra.setArraId(arraId);
    	   business mesBus = new business();
    	   mesBus.setBusId(busId);
    	   message temp = new message(null, mesArra, null, mesBus, type);
    	   mMapper.insert(temp);
       }
       

}
