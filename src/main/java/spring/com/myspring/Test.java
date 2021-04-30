package spring.com.myspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.com.myspring.pojo.Person;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Person myperson = (Person) ac.getBean("myperson");
        System.out.println(myperson);

    }
}