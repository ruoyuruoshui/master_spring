package spring.chapter_3.beanfactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class LEInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lecar")) {
			LECarLife car = (LECarLife) bean;
			if (car.getColor() == null) {
				System.out.println("Invoked BeanPostProcessor.postProcessBeforeInitialization "
						+ "car Color is null. Now we set it Black");
				car.setColor("Black");
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

	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("InstantiationAware BeanPostProcessor.postBeforeInstantiation");
		
		System.out.println("Instatiation Bean: " + beanClass);
		return null;
	}

	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if (beanName.equals("lecar")) {
			System.out.println("InstantiationAware BeanPostProcessor.postAfterInstantiation");
		}
		return true;
	}

	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		if (beanName.equals("lecar")) {
			System.out.println("Instantiation AwareBeanPostProcessor.postProcessPropertyValues");
			System.out.println("Instantiation Property Values" + pvs);
		}
		return pvs;
	}
}
