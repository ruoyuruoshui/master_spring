package spring.chapter_3.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class LEBeanLifeCycle {
	
	private static void LifeCycleBeanFactory() {
		Resource res = new ClassPathResource("spring/chapter_3/beanfactory/beans.xml");
		
		BeanFactory bf = new XmlBeanFactory(res);
		
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new LEBeanPostProcessor());
		
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new LEInstantiationAwareBeanPostProcessor());
		
		LECarLife lecar = (LECarLife)bf.getBean("lecar");
		System.out.println(lecar.introduce());
		
		LECarLife lecar2 = (LECarLife)bf.getBean("lecar");
		System.out.println("lecar1 == lecar2: " + (lecar == lecar2));
		
		((XmlBeanFactory)bf).destroySingletons();
	}
	
	
	public static void main (String[] args) {
		LifeCycleBeanFactory();
	}
}
