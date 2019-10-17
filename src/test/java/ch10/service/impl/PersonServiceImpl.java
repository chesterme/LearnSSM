package ch10.service.impl;

import ch10.pojo.Person;
import ch10.service.PersonService;
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
