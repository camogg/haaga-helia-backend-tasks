package com.exercises.chapter2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exercises.chapter2.domain.Person;
import com.exercises.chapter2.domain.Student;

import java.util.List;
import java.util.ArrayList;

@Controller
public class AppController {	
	/*
	 * handleHello1 handles requests for the first exercise.
	 * 
	 * handleHello2 handles requests for the second exercise.
	 * 
	 * handleIndex handles requests for the third exercise.
	 * 
	 * the fourth exercise is available on GitHub at https://github.com/loicprodhom/bookstore
	 * 
	 * */
	private List<Student> students = generateStudents();
	
//--Exercise 1--------------------------------------	
	
	@RequestMapping(value= {"/hello1"})
	public String handleHello1(@RequestParam(name="name") String name, @RequestParam(name="age") String age, Model model) {
		model.addAttribute("person", new Person(name, Integer.parseInt(age)));
		return "hello1";
	}

//--Exercise 2--------------------------------------
	
	@RequestMapping(value= {"/hello2"})
	public String handleHello2(Model model) {
		model.addAttribute("students", students);
		return "hello2";
	}
	
	private List<Student> generateStudents(){
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("pakalu","papito"));
		list.add(new Student("meme","man"));
		list.add(new Student("james","bond"));
		list.add(new Student("ash","ketchum"));
		return list;
	}

//--Exercise 3--------------------------------------
	
	@RequestMapping(value= {"/index"})
	public String handleIndex(Model model) {
		model.addAttribute("students", students);
		return "index";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Student student){
		students.add(student);
		return "redirect:index";
    } 
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("student", new Student());
        return "addfriend";
    } 
	
}
