package ch10.main;

import ch10.config.AppConfig;
import ch10.pojo.Person;
import ch10.service.PersonService;
import ch10.service.impl.PersonServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestComponent {

    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);

        PersonService personService = context.getBean(PersonServiceImpl.class);
        personService.print();


    }

}
