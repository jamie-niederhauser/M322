package com.example.application.views.main;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.sql.Statement;


@Service
public class PersonService {
	List<Person> list = new CopyOnWriteArrayList<>();
	List<Person> toBeDeleted = new CopyOnWriteArrayList<>();

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

	public void deleteCustomer(){
		list.removeAll(toBeDeleted);
	}

	public List<Person> getPerson(){
		return list;
	}

	public void setToBeDeleted(Set<Person> selected){
		toBeDeleted.clear();
		toBeDeleted.addAll(selected);
	}

	public List<Person> getToBeDeleted(){
		return toBeDeleted;
	}

}
