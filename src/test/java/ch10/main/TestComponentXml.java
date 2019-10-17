package ch10.main;

import ch10.pojo.Person;
import ch10.service.PersonService;
import ch10.service.impl.PersonServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestComponentXml {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("ch10/config/spring-config.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person);

        PersonService personService = context.getBean(PersonServiceImpl.class);
        personService.print();

    }

}
