package agentTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import agent.service.MatchService;

public class TestMatchService {
	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	 MatchService service = context.getBean(MatchService.class);
	 
	 @Test
	 public void testApplyToFirm(){
		 service.applyToFirm(3, 3, 1);
	 }
	 
	 @Test
	 public void testApplyToEmp(){
		 service.applyToEmp(1, 3, 1);
	 }
	 
	 @Test
	 public void testAudit(){
		 service.audit(true, 9);
	 }
}
