package ch13.service.impl;

import ch13.pojo.Person;
import ch13.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personServiceImpl")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private Person person = null;

    @Override
    public void print() {
        System.out.println(person);
    }
}
