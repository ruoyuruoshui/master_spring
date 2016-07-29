package spring.chapter_3.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LECarLife implements BeanFactoryAware, BeanNameAware, 
								InitializingBean, DisposableBean {
	
	private String brand;
	private String color;
	private int maxSpeed;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public String getBeanName() {
		return beanName;
	}

	public String getBrand() {
		return brand;
	}

	public LECarLife(){
		System.out.println("调用 LECarLife 的构造函数");
	}
	
	public void setBrand(String brand){
		System.out.println("调用 setBrand() 设置属性");
		this.brand = brand;
	}
	
	public String introduce() {
		return "Brand" + brand + " Color:" + color + " maxSpeed" + maxSpeed;
	}

	public void destroy() throws Exception {
		System.out.println("Invoked DisposableBean.destory()");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Invoked InitializingBean.afterPropertiesSet()");
	}

	public void setBeanName(String beanName) {
		System.out.println("Invoked BeanNameAware.setBeanName()");
		this.beanName = beanName;
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Invoke BeanFactory.setBeansFactory()");
		this.beanFactory = beanFactory;
	}
	
	public void myInit() {
		System.out.println("Invoked init-method 指定的Init(), 将maxSpeed 设置成为240");
		this.maxSpeed = 200;
	}

	// Dispose
	public void myDestroy() {
		System.out.println("Invoked destory-method 指定的 myDestory()");
	}
}
