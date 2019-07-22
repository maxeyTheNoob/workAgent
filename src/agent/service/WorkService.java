package agent.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agent.dao.workMapper;
import agent.pojo.business;
import agent.pojo.work;

@Service
@Transactional(rollbackFor=Exception.class)
public class WorkService {
       @Autowired
       private workMapper wMapper;
       
       @Transactional(readOnly=true)
       public work search(Integer workId,
       Integer workBus,
       Integer workMajor,
       Integer workExp,
       String workDet,
       Integer workSal,
       Integer workSta){
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(workId, bus, workMajor, workExp, workDet, workSal, workSta);
    	   return wMapper.selectByCondition(condition);
       }
       
       public void delete(Integer workId){
    	   wMapper.deleteByPrimaryKey(workId);
       }
       
       public void insert(
    	       Integer workBus,
    	       Integer workMajor,
    	       Integer workExp,
    	       String workDet,
    	       Integer workSal,
    	       Integer workSta){
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(null, bus, workMajor, workExp, workDet, workSal, workSta);
    	   wMapper.insert(condition);
       }
       
       public void update(Integer workId,
    	       Integer workBus,
    	       Integer workMajor,
    	       Integer workExp,
    	       String workDet,
    	       Integer workSal,
    	       Integer workSta) {
    	   business bus = new business();
    	   bus.setBusId(workBus);
    	   work condition = new work(workId, bus, workMajor, workExp, workDet, workSal, workSta);
    	   wMapper.updateByPrimaryKeySelective(condition);
	}
}
