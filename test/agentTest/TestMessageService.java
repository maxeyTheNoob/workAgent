package agentTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import agent.pojo.message;
import agent.service.MessageService;


public class TestMessageService {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	MessageService service = context.getBean(MessageService.class);
	
	
	@Test 
	public void testSendMatchMesToBus(){
		service.sendToBus(1, 4,0);
	}
}
