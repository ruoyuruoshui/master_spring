package spring.chapter_3.beanfactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class LEInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAware BeanPostProcessor.postBeforeInitialization");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAware BeanPostProcessor.postProcessAfterInitialization");
		return bean;
	}

	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("InstantiationAware BeanPostProcessor.postBeforeInstantiation");
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
		}
		return pvs;
	}
}
