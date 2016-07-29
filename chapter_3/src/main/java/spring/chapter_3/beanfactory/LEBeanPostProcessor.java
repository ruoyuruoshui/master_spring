package spring.chapter_3.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LEBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lecar")) {
			LECarLife car = (LECarLife) bean;
			if (car.getColor() == null) {
				System.out.println("Invoked BeanPostProcessor.postProcessBeforeInitialization "
						+ "car Color is null. Now we set it Black");
				car.setColor("Block");
			}
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lecar")) {
			LECarLife car = (LECarLife)bean;
			if (car.getMaxSpeed() >= 200) {
				System.out.println("adjust BeanPostProcessor.postProcess AfterInitilization(), setMaxSpeed To 200");
			}
			car.setMaxSpeed(200);
		}
		return bean;
	}
}
