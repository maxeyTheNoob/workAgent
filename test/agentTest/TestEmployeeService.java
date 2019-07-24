package agentTest;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import agent.pojo.arrangement;
import agent.pojo.employee;
import agent.service.EmployeeService;



public class TestEmployeeService {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	EmployeeService service = context.getBean(EmployeeService.class);
	
	@Test
	public void testSearch(){
		employee[] list= service.search(1, null, null, null, null, null);
		for(employee e:list){
			System.out.println(e);
		}
	}
	
	@Test
	public void testAdd(){
		service.add("ÕÅÈý", "ÄÐ", 3, 0, 2);
	}
	
	@Test
	public void testDelete(){
		service.delete(2);
	}
	
	@Test
	public void testUpdate(){
		service.update(1,null, "Å®", null, null, null);
	}
	
	@Test
	public void testSearchOldArra(){
		arrangement[] list=service.searchOldArra(1);
		for(arrangement a:list){
			System.out.println(a);
		}
	}
	
	@Test
	public void testSearchPassArra(){
		arrangement[] list=service.searchPassArra(1);
		for(arrangement a:list){
			System.out.println(a);
		}
	}
}
