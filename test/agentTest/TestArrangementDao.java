package agentTest;

import agent.dao.arrangementMapper;
import agent.pojo.arrangement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestArrangementDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	arrangementMapper mapper = context.getBean(arrangementMapper.class);
	
	@Test
	public void testSelectById(){
		arrangement arra = mapper.selectByPrimaryKey(1);
		System.out.println(arra);
	}
}
