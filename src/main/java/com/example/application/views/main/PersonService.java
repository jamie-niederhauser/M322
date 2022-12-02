package com.example.application.views.main;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PersonService {
	List<Person> list = new CopyOnWriteArrayList<>();

	public PersonService(){
		configureList();
	}

	public void configureList(){
		list.add(new Person("Anna","hfjf" , "anna@abc.com", "hfh"));
		list.add(new Person("Peter", "jf" , "Peter@abc.com", "hf"));
		list.add(new Person("Marc", "hfh", "marc@abc.com", "ut"));
		list.add(new Person("Susy", "utu", "susy@abc.com", "utp"));
	}

	public void addCustomer(Person person){
		list.add(person);
	}

	public List<Person> getPerson(){
		return list;
	}
}
