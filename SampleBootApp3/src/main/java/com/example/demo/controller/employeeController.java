package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.employee;
import com.example.demo.repository.EmployeeRepositry;


@Controller
public class employeeController {
	
	@Autowired
	EmployeeRepositry emplooyeeRepositry;
	
	//一覧表示
	@GetMapping("/")
	public ModelAndView selectAll(ModelAndView model) {
		Iterable<employee> userlist = emplooyeeRepositry.findAll();
	    model.addObject("userlist", userlist);
	    model.setViewName("user/list");
	    return model;
	}
	
	//登録_start
	@RequestMapping(value = "/user/insert_start", method = RequestMethod.POST)
	public ModelAndView insertStart(@ModelAttribute("formModel") employee emp, ModelAndView model) {
		
		model.setViewName("user/insert");
		
		return model;
			
	}
	
	//登録_do
	@RequestMapping(value = "/user/insert_do", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("formModel") employee emp, ModelAndView model) {
		
		emplooyeeRepositry.save(emp);
		
		return selectAll(model);
		
	}
	
	//ブランチ
	@RequestMapping(value = "user/branch", method=RequestMethod.POST)
	public ModelAndView branch(
			@RequestParam(name = "delete", required = false) String delete, 
			@RequestParam(name = "edit", required = false) String edit, 
			@RequestParam("id") String id, 
			ModelAndView model) {
		
		String str = null;
		if(delete != null) {
			str = delete;
		} else if (edit != null) {
			str = edit;
		}
		
		switch (str) {
		case "ユーザ情報削除": 
			return delete(id, model);
		case "ユーザ情報編集":
			return select(id, model);
		
		}
		return null;
	}
	
	//一件表示
	public ModelAndView select(String id,  ModelAndView model) {
		Optional<employee> userlist = emplooyeeRepositry.findById(id);
		model.addObject("userlist", userlist.get());
		model.setViewName("user/edit");
		return model;
	}
	
	//編集
	@RequestMapping(value = "user/edit", method=RequestMethod.POST)
	public ModelAndView edit(
			@RequestParam(name = "id")String id, 
			@RequestParam(name = "busyo")String busyo,
			@RequestParam(name = "person_name")String person_name,
			@RequestParam(name = "age")int age,
			@RequestParam(name = "telno")String telno,
			ModelAndView model) {
		
		employee emp = new employee();
		emp.setId(id);
		emp.setBusyo(busyo);
		emp.setPerson_name(person_name);
		emp.setAge(age);
		emp.setTelno(telno);
		
		emplooyeeRepositry.saveAndFlush(emp);
		
		return selectAll(model);
	}
	
	//削除
	public ModelAndView delete(String str, ModelAndView model) {
			
		emplooyeeRepositry.deleteById(str);
			
		return selectAll(model);
	}
	
	
	
}
