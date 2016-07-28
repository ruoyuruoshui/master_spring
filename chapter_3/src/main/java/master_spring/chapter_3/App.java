package master_spring.chapter_3;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ResourcePatternResolver resolver =  new PathMatchingResourcePatternResolver();
    	Resource res = resolver.getResource("master_spring/chapter_3/beans.xml");
    	
    	XmlBeanFactory bf = new XmlBeanFactory(res);
    	LECar car = bf.getBean("car", LECar.class);
    	
    	System.out.println(car.introduce());
    }
}
